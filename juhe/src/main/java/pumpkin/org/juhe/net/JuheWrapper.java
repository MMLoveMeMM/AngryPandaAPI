package pumpkin.org.juhe.net;

import org.json.JSONObject;

import java.util.HashMap;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import pumpkin.org.juhe.net.model.JuHeNews;

/**
 * @author: zhibao.Liu
 * @version:
 * @date: 2018/12/11 12:11
 * @des:
 * @see {@link }
 */

public class JuheWrapper extends JuheRetrofitManager{
    public final static String TAG = JuheWrapper.class.getSimpleName();
    private final int pageSize = 10;

    /**
     * 下面是两种不同的提交方式
     * */
    public Flowable<JuHeNews> getJuHeInfo(JSONObject request) {
        RequestBody body = RequestBody.create(RETROFIT_JSON,request.toString());
        return getService().getJuHeMessage(body);
    }
    /**
     * 获取聚合数据测试
     * */
    public Flowable<JuHeNews> getJuHeInfo(HashMap<String, String> request) {
        RequestBody body = JuheRetrofitManager.createRequestBody(request);
        return getService().getJuHeMessage(body);
    }

}
