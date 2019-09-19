package ximalayaos.net;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import ximalayaos.net.model.JuHeChengYu;
import ximalayaos.net.model.JuHeNews;
import ximalayaos.net.model.JuHeNewsStr;
import ximalayaos.net.model.category.XiCategoryBean;

/**
 * @author: zhibao.Liu
 * @version:
 * @date: 2018/12/11 12:11
 * @des:
 * @see {@link }
 */

public class XiMaLayaOsWrapper extends RetrofitManager{
    public final static String TAG = XiMaLayaOsWrapper.class.getSimpleName();
    private final int pageSize = 10;

    /**
     * 下面是两种不同的提交方式
     * */
    public Observable<JuHeNews> getJuHeInfo(JSONObject request) {
        RequestBody body = RequestBody.create(RETROFIT_JSON,request.toString());
        return getService().getJuHeMessage(body).compose(this.<JuHeNews>applySchedulers());
    }
    /**
     * 获取聚合数据测试
     * */
    public Observable<JuHeNews> getJuHeInfo(HashMap<String, String> request) {
        RequestBody body = RetrofitManager.createRequestBody(request);
        return getService().getJuHeMessage(body).compose(this.<JuHeNews>applySchedulers());
    }

    public Observable<JuHeNewsStr> getJuHeInfoStr(HashMap<String, String> request) {
        RequestBody body = RetrofitManager.createRequestBody(request);
        return getService().getJuHeMessageStr(body).compose(this.<JuHeNewsStr>applySchedulers());
    }

    public Observable<JuHeChengYu> getChengYuInfo(HashMap<String, String> request) {
        RequestBody body = RetrofitManager.createRequestBody(request);
        return getService().getChengYuMessage(body).compose(this.<JuHeChengYu>applySchedulers());
    }

    public void getXiCategoriesList(HashMap<String, String> request) {
        Call<ResponseBody> call = null;
        try {
            call = getService().getCategoriesList(request);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Response<ResponseBody> response) {
                    //主线程
                    try {
                        if (response != null && response.body() != null) {
                            String strByJson = "" + response.body().string();
                            Log.e("PostTest", "response---->" + strByJson);
                            // Gson gson = new Gson();
                            // List<XiCategoriesList> list = (List<XiCategoriesList>) gson.fromJson(response.body().string(),XiCategoriesList.class);
                            //String cateName = list.getData().get(0).getCategory_name();
                            // String strByJson = ""+response.body().string();
                            //Json的解析类对象
                            JsonParser parser = new JsonParser();
                            //将JSON的String 转成一个JsonArray对象
                            JsonArray jsonArray = parser.parse(strByJson).getAsJsonArray();

                            Gson gson = new Gson();
                            ArrayList<XiCategoryBean> userBeanList = new ArrayList<>();

                            //加强for循环遍历JsonArray
                            for (JsonElement user : jsonArray) {
                                //使用GSON，直接转成Bean对象
                                XiCategoryBean userBean = gson.fromJson(user, XiCategoryBean.class);
                                userBeanList.add(userBean);
                            }

                            Log.e("PostTest", "cateName----> : " + userBeanList.get(0).getCategory_name());
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
