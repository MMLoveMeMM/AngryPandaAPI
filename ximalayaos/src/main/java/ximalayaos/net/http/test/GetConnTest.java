package ximalayaos.net.http.test;

import java.util.Map;

import ximalayaos.net.http.HttpConnection;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: GetConnTest
 * @Author: 刘志保
 * @CreateDate: 2019/9/16 16:12
 * @Description: Get请求测试类1
 */
public class GetConnTest {
    /**
     * 积分商品列表
     */
    public static void getQuery(Map<String,String> params) {

        String url = "https://api.ximalaya.com/categories/list";
        new HttpConnection(url, HttpConnection.HttpMethod.GET,
                null,null, params);
    }


}
