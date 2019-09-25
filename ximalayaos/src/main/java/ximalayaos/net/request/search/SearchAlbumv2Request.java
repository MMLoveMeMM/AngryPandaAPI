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
import ximalayaos.net.model.searchalbumv2.SearchAlbumv2Bean;
import ximalayaos.net.request.IRequest;
import ximalayaos.net.request.RequestConfig;
import ximalayaos.net.params.ParamsMap;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: SearchAlbumv2Request
 * @Author: 刘志保
 * @CreateDate: 2019/9/17 16:06
 * @Description: java类作用描述
 */
public class SearchAlbumv2Request {
    private static final String TAG = SearchAlbumv2Request.class.getName();

    public static void httpSearchAlbumv2Request(Context context, final IRequest iRequest) {
        HashMap<String, String> paramsMap = new HashMap<>();
        ParamsMap.addCommonParams(context, paramsMap);

        httpRequest(paramsMap, iRequest);
    }

    public static void httpSearchAlbumv2Request(Context context, String title,int type, final IRequest iRequest) {
        HashMap<String, String> paramsMap = new HashMap<>();

        if(type==0){
            paramsMap.put("title", title);
        }else {
            paramsMap.put("tags", title);
        }
        ParamsMap.addCommonParams(context, paramsMap);
        httpRequest(paramsMap, iRequest);
    }

    public static void httpSearchAlbumv2Request(Context context, long id, String title, long uid,
                                                String nickname, String tags, int isPaid, int priceType,
                                                long categoryId, String categoryName, String sortBy, boolean desc,
                                                int page, int count,
                                                final IRequest iRequest) {
        HashMap<String, String> paramsMap = new HashMap<>();
        // 专辑ID
        paramsMap.put("id", "" + id);
        // 专辑标题
        paramsMap.put("title", title);
        // 主播uid
        paramsMap.put("uid", "" + uid);
        // 主播昵称
        paramsMap.put("nickname", "" + nickname);
        // 每页大小，范围为[1,200]，默认为20
        paramsMap.put("tags", tags);
        //  是否付费 1-付费 0-免费
        paramsMap.put("is_paid", "" + isPaid);
        // 价格类型 1-分集购买 2-整张购买
        paramsMap.put("price_type", tags);
        // 分类ID
        paramsMap.put("category_id", "" + categoryId);
        // 分类名
        paramsMap.put("category_name", categoryName);
        // 排序字段，可选值：created_at、updated_at、discountedPrice、play_count、week_score_plus
        paramsMap.put("sort_by", sortBy);
        //  	true-降序排列 false-升序排列
        paramsMap.put("desc", desc ? "true" : "false");

        paramsMap.put("page", "" + page);

        paramsMap.put("count", "" + count);

        ParamsMap.addCommonParams(context, paramsMap);

        httpRequest(paramsMap, iRequest);

    }

    public static void httpRequest(Map<String, String> paramsMap, final IRequest iRequest) {
        Call<ResponseBody> call = null;
        try {
            call = RetrofitManager.getService().getSearchAlbumv2List(paramsMap);
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
                            SearchAlbumv2Bean bean = gson.fromJson(rawJson, SearchAlbumv2Bean.class);

                            if (iRequest != null) {
                                iRequest.callBackRequestBean(bean);
                            }
                            Log.e("PostTest", "search album ----> : " + bean.getAlbums().get(0).getAlbum_title());
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
