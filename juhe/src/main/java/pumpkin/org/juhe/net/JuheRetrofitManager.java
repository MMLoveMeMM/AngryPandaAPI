package pumpkin.org.juhe.net;

import android.util.Log;

import org.reactivestreams.Subscriber;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import pumpkin.org.juhe.net.model.BaseResult;
//import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
//import retrofit2.RxJavaCallAdapterFactory;
/*import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;*/

/**
 * @author: zhibao.Liu
 * @version:
 * @date: 2018/12/6 19:20
 * @des:
 * @see {@link }
 */
public class JuheRetrofitManager {

    public static final String TAG = JuheRetrofitManager.class.getSimpleName();
    /**
     * 服务器地址
     */
    private static final String API_HOST = "http://v.juhe.cn";

    public static final MediaType RETROFIT_JSON = MediaType.parse("application/json; charset=utf-8");

    private static JuheService service;
    private static Retrofit retrofit;

    public static JuheService getService() {
        if (service == null) {
            service = getRetrofit().create(JuheService.class);
        }
        return service;
    }

    private static Retrofit getRetrofit() {
        if (retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    Log.i("RxJava", message);
                }
            });
            //网络缓存路径文件
            // File httpCacheDirectory = new File(BaseApplication.getInstance().getExternalCacheDir(), "responses");
            //通过拦截器设置缓存，暂未实现
            // CacheInterceptor cacheInterceptor = new CacheInterceptor();

            OkHttpClient client = new OkHttpClient.Builder()
                    //设置缓存
                    // .cache(new Cache(httpCacheDirectory, 10 * 1024 * 1024))
                    //log请求参数
                    .addInterceptor(new LoggingInterceptor()/*interceptor*/)
                    //网络请求缓存，未实现
                    // .addInterceptor(cacheInterceptor)
                    .build();
            retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(API_HOST)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static class HttpException extends Exception {
        public int code;
        public String message;

        public HttpException(int resultcode, String reason) {
            this.code = resultcode;
            this.message = reason;
        }

        @Override
        public String getMessage() {
            return message;
        }
    }



    /**
     * 当{@link JuheWrapper}中接口的注解为{@link retrofit2.http.Multipart}时，参数为{@link RequestBody}
     * 生成对应的RequestBody
     *
     * @param param
     * @return
     */
    protected RequestBody createRequestBody(int param) {
        return RequestBody.create(MediaType.parse("text/plain"), String.valueOf(param));
    }

    protected RequestBody createRequestBody(long param) {
        return RequestBody.create(MediaType.parse("text/plain"), String.valueOf(param));
    }

    protected RequestBody createRequestBody(String param) {
        return RequestBody.create(MediaType.parse("text/plain"), param);
    }

    protected RequestBody createRequestBody(File param) {
        return RequestBody.create(MediaType.parse("image/*"), param);
    }

    public static RequestBody createRequestBody(HashMap<String, String> hashMap) {
        StringBuffer data = new StringBuffer();
        if (hashMap != null && hashMap.size() > 0) {
            Iterator iter = hashMap.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                Object key = entry.getKey();
                Object val = entry.getValue();
                data.append(key).append("=").append(val).append("&");
            }
        }
        String jso = data.substring(0, data.length() - 1);
        RequestBody requestBody =
                RequestBody.create(MediaType.parse("application/x-www-form-urlencoded; charset=utf-8"), jso);

        return requestBody;
    }

    /**
     * 已二进制传递图片文件，对图片文件进行了压缩
     *
     * @param path 文件路径
     * @return
     */
    /*protected RequestBody createPictureRequestBody(String path) {
        Bitmap bitmap = ClippingPicture.decodeResizeBitmapSd(path, 400, 800);
        return RequestBody.create(MediaType.parse("image*//**//*"), ClippingPicture.bitmapToBytes(bitmap));
    }*/


}
