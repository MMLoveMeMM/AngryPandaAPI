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
import ximalayaos.net.model.sugwords.SuggestWordsBean;
import ximalayaos.net.request.IRequest;
import ximalayaos.net.request.RequestConfig;
import ximalayaos.net.params.ParamsMap;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: SearchSuggestWordsRequest
 * @Author: 刘志保
 * @CreateDate: 2019/9/17 19:09
 * @Description: java类作用描述
 */
public class SearchSuggestWordsRequest {
    private static final String TAG = SearchSuggestWordsRequest.class.getName();

    public static void httpSearchSuggestWordsRequest(Context context, String q ,final IRequest iRequest){
        HashMap<String, String> paramsMap = new HashMap<>();
        // 搜索关键词
        paramsMap.put("q", q);

        ParamsMap.addCommonParams(context, paramsMap);

        httpRequest(paramsMap, iRequest);
    }

    public static void httpRequest(Map<String, String> paramsMap, final IRequest iRequest){
        Call<ResponseBody> call = null;
        try {
            call = RetrofitManager.getService().getSearchSuggestWordsList(paramsMap);
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
                            SuggestWordsBean bean = gson.fromJson(rawJson,SuggestWordsBean.class);

                            if (iRequest != null) {
                                iRequest.callBackRequestBean(bean);
                            }
                            Log.e("PostTest", "search sug ----> : " + bean.getAlbums().get(0).getAlbum_title());
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
