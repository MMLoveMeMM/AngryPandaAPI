package ximalayaos.net.request.search;

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
import ximalayaos.net.model.searchalbum.SearchAlbumBean;
import ximalayaos.net.request.IRequest;
import ximalayaos.net.request.RequestConfig;
import ximalayaos.net.params.ParamsMap;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: SearchAlbumRequest
 * @Author: 刘志保
 * @CreateDate: 2019/9/17 15:42
 * @Description: java类作用描述
 */
public class SearchAlbumRequest {

    private static final String TAG = SearchAlbumRequest.class.getName();

    public static void httpSearchAlbumRequest(Context context, String q, final IRequest iRequest){
        HashMap<String, String> paramsMap = new HashMap<>();
        // 搜索关键词
        paramsMap.put("q", q);
        ParamsMap.addCommonParams(context, paramsMap);

        httpRequest(paramsMap, iRequest);
    }

    public static void httpSearchAlbumRequest(Context context, String q, int categoryId, int calcDimension,
                                          int page, int count, final IRequest iRequest) {
        HashMap<String, String> paramsMap = new HashMap<>();
        // 搜索关键词
        paramsMap.put("q", q);
        // 分类ID。分类数据可以通过/categories/list 获取
        paramsMap.put("category_id", ""+categoryId);
        // 返回结果排序维度：1-最火，2-最新，3-最多播放
        paramsMap.put("calc_dimension", ""+calcDimension);
        // 返回第几页，从1开始，默认为1
        paramsMap.put("page", ""+page);
        // 每页大小，范围为[1,200]，默认为20
        paramsMap.put("count", ""+count);
        ParamsMap.addCommonParams(context, paramsMap);

        httpRequest(paramsMap, iRequest);
    }

    public static void httpRequest(Map<String, String> paramsMap, final IRequest iRequest) {
        Call<ResponseBody> call = null;
        try {
            call = RetrofitManager.getService().getSearchAlbumList(paramsMap);
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
                            SearchAlbumBean bean = gson.fromJson(rawJson,SearchAlbumBean.class);

                            if (iRequest != null) {
                                iRequest.callBackRequestBean(bean);
                            }
                            Log.e("PostTest", "search album ----> : " + bean.getAlbums().get(0).getLast_uptrack().getTrack_id());
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
