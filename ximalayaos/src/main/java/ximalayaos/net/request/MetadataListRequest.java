package ximalayaos.net.request;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ximalayaos.net.RetrofitManager;
import ximalayaos.net.model.metalist.MetaListBean;
import ximalayaos.net.model.metalist.MetaListBeanList;
import ximalayaos.net.params.ParamsMap;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: MetadataListRequest
 * @Author: 刘志保
 * @CreateDate: 2019/9/17 11:59
 * @Description: java类作用描述
 */
public class MetadataListRequest {
    private static final String TAG = MetadataListRequest.class.getName();

    public static void httpMetadataListRequest(Context context, int categoryId, final IRequest iRequest) {
        HashMap<String, String> paramsMap = new HashMap<>();
        // 该声音所属专辑ID
        paramsMap.put("category_id", "" + categoryId);
        ParamsMap.addCommonParams(context, paramsMap);
        httpRequest(paramsMap, iRequest);
    }

    public static void httpRequest(Map<String, String> paramsMap, final IRequest iRequest) {
        Call<ResponseBody> call = null;
        try {
            call = RetrofitManager.getService().getMetadataList(paramsMap);
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
                            //Json的解析类对象
                            JsonParser parser = new JsonParser();
                            //将JSON的String 转成一个JsonArray对象
                            JsonArray jsonArray = parser.parse(rawJson).getAsJsonArray();

                            Gson gson = new Gson();
                            ArrayList<MetaListBean> tagList = new ArrayList<>();

                            //加强for循环遍历JsonArray
                            for (JsonElement user : jsonArray) {
                                //使用GSON，直接转成Bean对象
                                MetaListBean userBean = gson.fromJson(user, MetaListBean.class);
                                tagList.add(userBean);
                            }
                            MetaListBeanList listBean = new MetaListBeanList();
                            listBean.setData(tagList);
                            if (iRequest != null) {
                                iRequest.callBackRequestBean(listBean);
                            }
                            Log.e("PostTest", "meta list ----> : " + tagList.get(0).getAttributes().get(0).getDisplay_name());
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
