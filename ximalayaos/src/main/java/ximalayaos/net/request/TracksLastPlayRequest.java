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
import ximalayaos.net.model.trackslast.TracksLastPlayBean;
import ximalayaos.net.params.ParamsMap;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: TracksLastPlayRequest
 * @Author: 刘志保
 * @CreateDate: 2019/9/17 11:46
 * @Description: java类作用描述
 */
public class TracksLastPlayRequest {
    private static final String TAG = TracksLastPlayRequest.class.getName();

    public static void httpTracksLastPlayRequest(Context context,int albumId,int trackId, final IRequest iRequest){
        HashMap<String, String> paramsMap = new HashMap<>();
        // 该声音所属专辑ID
        paramsMap.put("album_id", ""+albumId);
        // 声音ID
        paramsMap.put("track_id", ""+trackId);
        // 每页大小，范围为[1,200]，默认为20
        paramsMap.put("count", "20");
        // 正序取页结果或倒序取页结果："asc" - 正序，"desc" - 倒序，默认为"asc"
        paramsMap.put("sort", "asc");
        // 是否输出付费内容（即返回值是否包含付费内容）：true-是；false-否；默认不填为false
        paramsMap.put("contains_paid", "false");

        ParamsMap.addCommonParamsEx(context, paramsMap);

        httpRequest(paramsMap, iRequest);
    }

    public static void httpTracksLastPlayRequest(Context context,int albumId,int trackId,int count,
            String sort,boolean containPaid, final IRequest iRequest){
        HashMap<String, String> paramsMap = new HashMap<>();
        // 该声音所属专辑ID
        paramsMap.put("album_id", ""+albumId);
        // 声音ID
        paramsMap.put("track_id", ""+trackId);
        // 每页大小，范围为[1,200]，默认为20
        paramsMap.put("count", ""+count);
        // 正序取页结果或倒序取页结果："asc" - 正序，"desc" - 倒序，默认为"asc"
        paramsMap.put("sort", sort);
        // 是否输出付费内容（即返回值是否包含付费内容）：true-是；false-否；默认不填为false
        paramsMap.put("contains_paid", containPaid?"true":"false");

        ParamsMap.addCommonParamsEx(context, paramsMap);

        httpRequest(paramsMap, iRequest);
    }

    public static void httpRequest(Map<String, String> paramsMap, final IRequest iRequest){
        Call<ResponseBody> call = null;
        try {
            call = RetrofitManager.getService().getTracksLastPlayList(paramsMap);
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
                             * 暂时没有获取到有效json信息
                             */
                            Gson gson = new Gson();
                            TracksLastPlayBean bean = gson.fromJson(rawJson,TracksLastPlayBean.class);
                            if (iRequest != null) {
                                iRequest.callBackRequestBean(bean);
                            }
                            Log.e("PostTest", "last paly ----> : " + bean.getTracks().get(0).getTrack_title());

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
