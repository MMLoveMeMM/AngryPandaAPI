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
import ximalayaos.net.model.colbrowse.ColumnsBrowseBean;
import ximalayaos.net.params.ParamsMap;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: ColumnsBrowseRequest
 * @Author: 刘志保
 * @CreateDate: 2019/9/17 15:16
 * @Description: 分页获取听单内容
 */
public class ColumnsBrowseRequest {
    private static final String TAG = ColumnsBrowseRequest.class.getName();

    public static void httpColumnsBrowseRequest(Context context, long id, int page, int count, final IRequest iRequest) {
        HashMap<String, String> paramsMap = new HashMap<>();
        // 用于获取具体榜单内容的榜单ID，可以先通过 /v3/ranks/index_list获得
        paramsMap.put("id", "" + id);
        paramsMap.put("page", "" + page);
        paramsMap.put("count", "" + count);
        ParamsMap.addCommonParams(context, paramsMap);

        httpRequest(paramsMap, iRequest);
    }

    public static void httpRequest(Map<String, String> paramsMap, final IRequest iRequest) {
        Call<ResponseBody> call = null;
        try {
            call = RetrofitManager.getService().getColumnsBrowseList(paramsMap);
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
                            /**
                             * 下面将json转换成javabean返回
                             */
                            Gson gson = new Gson();
                            ColumnsBrowseBean bean = gson.fromJson(rawJson,ColumnsBrowseBean.class);

                            if (iRequest != null) {
                                iRequest.callBackRequestBean(bean);
                            }
                            Log.e("PostTest", "rank album----> : " + bean.getValues().get(0).getTrack_title());
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
