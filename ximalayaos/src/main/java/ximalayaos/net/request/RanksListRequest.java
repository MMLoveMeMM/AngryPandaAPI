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
import ximalayaos.net.model.rankslist.RankListBean;
import ximalayaos.net.model.rankslist.RanksList;
import ximalayaos.net.params.ParamsMap;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: RanksListRequest
 * @Author: 刘志保
 * @CreateDate: 2019/9/17 14:21
 * @Description: java类作用描述
 */
public class RanksListRequest extends BaseRequest {

    private static final String TAG = RanksListRequest.class.getName();

    public static void httpRanksListRequest(Context context, int rankType, final IRequest iRequest) {
        HashMap<String, String> paramsMap = new HashMap<>();
        // 榜单类型：1-节目榜单。目前只有一种类型
        paramsMap.put("rank_type", "" + rankType);
        ParamsMap.addCommonParams(context, paramsMap);

        httpRequest(paramsMap, iRequest);

    }

    public static void httpRequest(Map<String, String> paramsMap, final IRequest iRequest) {

        Call<ResponseBody> call = null;
        try {
            call = RetrofitManager.getService().getRanksList(paramsMap);
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
                            ArrayList<RankListBean> tagList = new ArrayList<>();

                            //加强for循环遍历JsonArray
                            for (JsonElement user : jsonArray) {
                                //使用GSON，直接转成Bean对象
                                RankListBean userBean = gson.fromJson(user, RankListBean.class);
                                tagList.add(userBean);
                            }
                            RanksList listBean = new RanksList();
                            listBean.setData(tagList);
                            if (iRequest != null) {
                                iRequest.callBackRequestBean(listBean);
                            }
                            Log.e("PostTest", "rank list----> : " + tagList.get(0).getRank_first_item_title());
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
