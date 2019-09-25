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

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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

    public void getXiCategoriesList(HashMap<String, String> request) {
        Call<ResponseBody> call = null;
        try {
            call = getService().getCategoriesList(request);
            call.enqueue(new Callback<ResponseBody>() {

                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
