package pumpkin.org.juhe.net;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import pumpkin.org.juhe.net.model.JuHeNews;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author: zhibao.Liu
 * @version:
 * @date: 2018/12/6 19:20
 * @des:
 * @see {@link }
 */
public interface JuheService {

    /**
     * 测试API
     * */
    @POST("/toutiao/index")
    //  此处回调返回的可为任意类型Call<T>，再也不用自己去解析json数据啦！！！
    Flowable<JuHeNews> getJuHeMessage(@Body RequestBody body/*@Query("type") String type, @Query("key") String key*/);

}
