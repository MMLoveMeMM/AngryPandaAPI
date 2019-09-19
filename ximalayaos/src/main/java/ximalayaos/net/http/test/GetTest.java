package ximalayaos.net.http.test;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import ximalayaos.net.http.ApiService;
import ximalayaos.net.model.category.XiCategoryBean;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: GetTest
 * @Author: 刘志保
 * @CreateDate: 2019/9/16 14:40
 * @Description: Get请求测试类2
 */
public class GetTest {

    private static final String TAG =GetTest.class.getName();

    public static void getTest(Map<String,String> body){
        String baseUrl = "https://api.ximalaya.com";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .build();
        ApiService apiService = retrofit.create(ApiService.class);

        Call<ResponseBody> call = null;
        try {
            call = apiService.getQueryMapData(body);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Response<ResponseBody> response) {
                    //主线程
                    try {
                        if(response!=null && response.body() != null) {
                            String strByJson = ""+response.body().string();
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
                    Log.e(TAG,"Throwable---->" + t.getMessage());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
