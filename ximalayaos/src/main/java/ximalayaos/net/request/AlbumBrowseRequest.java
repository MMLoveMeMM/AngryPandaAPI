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
import ximalayaos.net.model.albbrowse.AlbumsBrowseBean;
import ximalayaos.net.params.ParamsMap;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: AlbumBrowseRequest
 * @Author: 刘志保
 * @CreateDate: 2019/9/17 10:53
 * @Description: java类作用描述
 */
public class AlbumBrowseRequest {
    private static final String TAG = AlbumBrowseRequest.class.getName();

    public static void httpAlbumBrowseRequest(Context context,int albumId,final IRequest iRequest){
        HashMap<String, String> paramsMap = new HashMap<>();
        // 专辑ID
        paramsMap.put("album_id", ""+albumId);
        // 返回结果排序方式： 默认为"asc"
        paramsMap.put("sort", "asc");
        // 返回第几页，从1开始，默认为1
        paramsMap.put("page", "1");
        // 每页大小，范围为[1,200]，默认为20
        paramsMap.put("count", "20");
        ParamsMap.addCommonParamsEx(context,paramsMap);
        httpRequest(paramsMap,iRequest);
    }

    public static void httpAlbumBrowseRequest(Context context,int albumId,String sort,int page,int count, final IRequest iRequest){
        HashMap<String, String> paramsMap = new HashMap<>();
        // 专辑ID
        paramsMap.put("album_id", ""+albumId);
        // 返回结果排序方式： 默认为"asc"
        paramsMap.put("sort", sort);
        // 返回第几页，从1开始，默认为1
        paramsMap.put("page", ""+page);
        // 每页大小，范围为[1,200]，默认为20
        paramsMap.put("count", ""+count);
        ParamsMap.addCommonParams(context,paramsMap);
        httpRequest(paramsMap,iRequest);
    }

    public static void httpRequest(Map<String, String> paramsMap, final IRequest iRequest){
        Call<ResponseBody> call = null;
        try {
            call = RetrofitManager.getService().getAlbumBrowseList(paramsMap);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Response<ResponseBody> response) {
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
                            AlbumsBrowseBean bean = gson.fromJson(rawJson,AlbumsBrowseBean.class);

                            if (iRequest != null) {
                                iRequest.callBackRequestBean(bean);
                            }
                            Log.e("PostTest", "album browse ----> : " + bean.getAlbum_title());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Throwable t) {
                    Log.e(TAG, "Throwable---->" + t.getMessage());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
