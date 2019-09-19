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
import ximalayaos.net.model.columnsbatch.ColumnBatchBean;
import ximalayaos.net.params.ParamsMap;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: ColumnsBatchRequest
 * @Author: 刘志保
 * @CreateDate: 2019/9/17 15:08
 * @Description: 批量获取听单信息
 */
public class ColumnsBatchRequest {

    private static final String TAG = ColumnsBatchRequest.class.getName();

    public static void httpColumnsBatchRequest(Context context,String ids,final IRequest iRequest){
        HashMap<String, String> paramsMap = new HashMap<>();
        // 用于获取具体榜单内容的榜单ID，可以先通过 /v3/ranks/index_list获得
        paramsMap.put("ids", ids);
        ParamsMap.addCommonParams(context,paramsMap);

        httpRequest(paramsMap,iRequest);
    }

    public static void httpRequest(Map<String, String> paramsMap, final IRequest iRequest){
        Call<ResponseBody> call = null;
        try {
            call = RetrofitManager.getService().getColumnsBatchList(paramsMap);
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
                             * 暂时没有具体的json数据提供
                             */
                            Gson gson = new Gson();
                            ColumnBatchBean bean = gson.fromJson(rawJson,ColumnBatchBean.class);

                            if (iRequest != null) {
                                iRequest.callBackRequestBean(bean);
                            }
                            Log.e("PostTest", "column batch----> : " + bean.getColumns().get(0).getTitle());
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
