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
import ximalayaos.net.model.metaalbum.MetaAblumBean;
import ximalayaos.net.params.ParamsMap;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: MetadataAblumsRequest
 * @Author: 刘志保
 * @CreateDate: 2019/9/17 12:18
 * @Description: java类作用描述
 */
public class MetadataAblumsRequest {
    private static final String TAG = MetadataAblumsRequest.class.getName();

    public static void httpMetadataAblumsRequest(Context context,int categoryId,int calcDimension,final IRequest iRequest){
        HashMap<String, String> paramsMap = new HashMap<>();
        // 该声音所属专辑ID
        paramsMap.put("category_id", ""+categoryId);
        // paramsMap.put("metadata_attributes", "");
        // 返回结果排序维度：1-最火，2-最新，3-最多播放
        paramsMap.put("calc_dimension", ""+calcDimension);
        paramsMap.put("page", "1");
        paramsMap.put("count", "20");
        ParamsMap.addCommonParams(context,paramsMap);
        httpRequest(paramsMap,iRequest);
    }

    public static void httpMetadataAblumsRequest(Context context,int categoryId,int calcDimension,int page,int count, final IRequest iRequest){
        HashMap<String, String> paramsMap = new HashMap<>();
        // 该声音所属专辑ID
        paramsMap.put("category_id", ""+categoryId);
        // paramsMap.put("metadata_attributes", "");
        // 返回结果排序维度：1-最火，2-最新，3-最多播放
        paramsMap.put("calc_dimension", ""+calcDimension);
        paramsMap.put("page", ""+page);
        paramsMap.put("count", ""+count);
        ParamsMap.addCommonParams(context,paramsMap);
        httpRequest(paramsMap,iRequest);
    }

    public static void httpRequest(Map<String, String> paramsMap, final IRequest iRequest){
        Call<ResponseBody> call = null;
        try {
            call = RetrofitManager.getService().getMetadataAblums(paramsMap);
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
                            MetaAblumBean bean = gson.fromJson(rawJson,MetaAblumBean.class);

                            if (iRequest != null) {
                                iRequest.callBackRequestBean(bean);
                            }
                            Log.e("PostTest", "meta album ----> : " + bean.getAlbums().get(0).getAlbum_title());
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
