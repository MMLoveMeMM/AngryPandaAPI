package ximalayaos.net.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ximalayaos.net.RetrofitManager;
import ximalayaos.net.model.tracksbatch.TracksBatchBean;
import ximalayaos.net.params.ParamsMap;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: TracksBatchRequest
 * @Author: 刘志保
 * @CreateDate: 2019/9/17 11:32
 * @Description: java类作用描述
 */
public class TracksBatchRequest {
    private static final String TAG = TracksBatchRequest.class.getName();

    public static void httpTracksBatchRequest(Context context, String ids, boolean onlyPlay, final IRequest iRequest) {

        HashMap<String, String> paramsMap = new HashMap<>();
        // 以英文逗号分隔的专辑ID
        paramsMap.put("ids", ids);
        paramsMap.put("only_play_info", onlyPlay ? "true" : "false");

        ParamsMap.addCommonParams(context, paramsMap);
        httpRequest(paramsMap, iRequest);
    }

    public static void httpRequest(Map<String, String> paramsMap, final IRequest iRequest) {
        Call<ResponseBody> call = null;
        try {
            call = RetrofitManager.getService().getTracksBatchList(paramsMap);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call,Response<ResponseBody> response) {
                    //主线程
                    try {
                        if (response != null && response.body() != null) {
                            String rawJson = "" + response.body().string();
                            Log.e("PostTest", "response---->" + rawJson);
                            if (TextUtils.isEmpty(rawJson) || rawJson.length() < RequestConfig.REQUEST_JSON_INVALID_LENGTH_LIMIT) {
                                if (iRequest != null) {
                                    iRequest.callBackRequestError(rawJson);
                                }
                                return;
                            }
                            if (iRequest != null) {
                                iRequest.callBackRequestResult(rawJson);
                            }

                            if (rawJson.length() < 50) {
                                return;
                            }
                            /**
                             * 下面将json转换成javabean返回
                             * 暂时没有获取到有效json信息
                             */
                            Gson gson = new Gson();
                            TracksBatchBean bean = gson.fromJson(rawJson, TracksBatchBean.class);

                            if (iRequest != null) {
                                iRequest.callBackRequestBean(bean);
                            }

                            Log.e("PostTest", "track batch ----> : " + bean.getTracks().get(0).getTrack_title());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call,Throwable t) {
                    Log.e(TAG, "Throwable---->" + t.getMessage());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
