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
import ximalayaos.net.model.album.AlbumsBean;
import ximalayaos.net.params.ParamsMap;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: AlbumRequest
 * @Author: 刘志保
 * @CreateDate: 2019/9/17 10:23
 * @Description: 获得专辑列表
 */
public class AlbumRequest {
    private static final String TAG = AlbumRequest.class.getName();

    public static void httpAlbumRequest(Context context, int categoryId, int calcDimension, final IRequest iRequest) {
        HashMap<String, String> paramsMap = new HashMap<>();
        // 分类ID，为0时表示热门分类。分类数据可以通过 /categories/list 获取
        paramsMap.put("category_id", "" + categoryId);
        // 专辑标签，可以通过传值为0的type参数去调 /v2/tags/list 获取
        paramsMap.put("tag_name", "0");
        // 返回结果排序维度：1-最火，2-最新，3-最多播放
        paramsMap.put("calc_dimension", "" + calcDimension);
        // 返回第几页，从1开始，默认为1
        paramsMap.put("page", "1");
        // 每页大小，范围为[1,200]，默认为20
        paramsMap.put("count", "20");
        // 是否输出付费内容（即返回值是否包含付费内容）：true-是；false-否；默认不填为false
        paramsMap.put("contains_paid", "false");
        ParamsMap.addCommonParams(context, paramsMap);
        httpRequest(paramsMap, iRequest);
    }

    public static void httpAlbumRequest(Context context, int categoryId, String tagName, int calcDimension,
                                        int page, int count, boolean containsPaid, final IRequest iRequest) {
        HashMap<String, String> paramsMap = new HashMap<>();
        // 分类ID，为0时表示热门分类。分类数据可以通过 /categories/list 获取
        paramsMap.put("category_id", "" + categoryId);
        // 专辑标签，可以通过传值为0的type参数去调 /v2/tags/list 获取
        paramsMap.put("tag_name", tagName);
        // 返回结果排序维度：1-最火，2-最新，3-最多播放
        paramsMap.put("calc_dimension", "" + calcDimension);
        // 返回第几页，从1开始，默认为1
        paramsMap.put("page", "" + page);
        // 每页大小，范围为[1,200]，默认为20
        paramsMap.put("count", "" + count);
        // 是否输出付费内容（即返回值是否包含付费内容）：true-是；false-否；默认不填为false
        paramsMap.put("contains_paid", containsPaid ? "true" : "false");
        ParamsMap.addCommonParams(context, paramsMap);
        httpRequest(paramsMap, iRequest);
    }

    public static void httpRequest(Map<String, String> paramsMap, final IRequest iRequest) {
        Call<ResponseBody> call = null;
        try {
            call = RetrofitManager.getService().getAlbumsList(paramsMap);
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
                            AlbumsBean bean = gson.fromJson(rawJson, AlbumsBean.class);

                            if (iRequest != null) {
                                iRequest.callBackRequestBean(bean);
                            }
                            Log.e("PostTest", "albumName----> : " + bean.getAlbums().get(0).getAlbum_title());
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
