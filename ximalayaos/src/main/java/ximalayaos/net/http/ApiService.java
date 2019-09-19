package ximalayaos.net.http;

import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;
import ximalayaos.net.model.JuHeChengYu;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: ApiService
 * @Author: 刘志保
 * @CreateDate: 2019/9/16 14:22
 * @Description: 适应Get请求测试类2
 */
public interface ApiService {
    // @Headers("Content-type:application/x-www-form-urlencoded;charset=UTF-8")
    @FormUrlEncoded
    @POST("/categories/list")  //注意  不是 /  结束
    Call<ResponseBody> postFile(@FieldMap Map<String,String> map);

    // @HEAD("Content-Type:application/x-www-form-urlencoded;charset=UTF-8")
    @GET("/categories/list")
    Call<ResponseBody> getQueryMapData(@QueryMap Map<String, String> map);

}
