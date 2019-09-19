package ximalayaos.net.request;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: RequestConfig
 * @Author: 刘志保
 * @CreateDate: 2019/9/18 10:06
 * @Description: 请求相关的参数配置
 */
public class RequestConfig {
    // json小于这个长度,不需要转换成javabean,很可能是非法字符串
    public static final int REQUEST_JSON_INVALID_LENGTH_LIMIT = 30;
}
