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
import ximalayaos.net.model.albbatch.AlbumBatchBean;
import ximalayaos.net.model.albbatch.AlbumBatchsList;
import ximalayaos.net.params.ParamsMap;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: AlbumBatchRequest
 * @Author: 刘志保
 * @CreateDate: 2019/9/17 11:06
 * @Description: java类作用描述
 */
public class AlbumBatchRequest {
    private static final String TAG = AlbumBatchRequest.class.getName();

    public static void httpAlbumBatchRequest(Context context, String ids, final IRequest iRequest) {
        HashMap<String, String> paramsMap = new HashMap<>();
        // 以英文逗号分隔的专辑ID，一次最多传200个，超出部分ID会被忽略
        paramsMap.put("ids", ids);
        // true代表返回metadata，false或不填不返回，获取所有元数据列表，可以使用接口/metadata/list
        paramsMap.put("with_metadata", "false");

        ParamsMap.addCommonParams(context, paramsMap);

        httpRequest(paramsMap, iRequest);
    }

    public static void httpAlbumBatchRequest(Context context, String ids, boolean withMeta, final IRequest iRequest) {
        HashMap<String, String> paramsMap = new HashMap<>();
        // 以英文逗号分隔的专辑ID，一次最多传200个，超出部分ID会被忽略
        paramsMap.put("ids", ids);
        // true代表返回metadata，false或不填不返回，获取所有元数据列表，可以使用接口/metadata/list
        paramsMap.put("with_metadata", withMeta ? "true" : "false");

        ParamsMap.addCommonParams(context, paramsMap);

        httpRequest(paramsMap, iRequest);
    }

    public static void httpRequest(Map<String, String> paramsMap, final IRequest iRequest) {
        Call<ResponseBody> call = null;
        try {
            call = RetrofitManager.getService().getAlbumBatchList(paramsMap);
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
                            //Json的解析类对象
                            JsonParser parser = new JsonParser();
                            //将JSON的String 转成一个JsonArray对象
                            JsonArray jsonArray = parser.parse(rawJson).getAsJsonArray();

                            Gson gson = new Gson();
                            ArrayList<AlbumBatchBean> categoryList = new ArrayList<>();

                            //加强for循环遍历JsonArray
                            for (JsonElement user : jsonArray) {
                                //使用GSON，直接转成Bean对象
                                AlbumBatchBean userBean = gson.fromJson(user, AlbumBatchBean.class);
                                categoryList.add(userBean);
                            }
                            AlbumBatchsList listBean = new AlbumBatchsList();
                            listBean.setData(categoryList);
                            if (iRequest != null) {
                                iRequest.callBackRequestBean(listBean);
                            }
                            Log.e("PostTest", "album batch----> : " + categoryList.get(0).getAlbum_title());
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
