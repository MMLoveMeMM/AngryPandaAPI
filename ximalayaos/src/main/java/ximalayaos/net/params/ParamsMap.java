package ximalayaos.net.params;

import android.content.Context;

import java.util.Map;

import ximalayaos.net.sign.Sign;
import ximalayaos.net.utils.Device;
import ximalayaos.net.utils.RndStr;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: ParamsMap
 * @Author: 刘志保
 * @CreateDate: 2019/9/17 10:11
 * @Description: java类作用描述
 */
public class ParamsMap {

    public static void addCommonParams(Context context,Map<String, String> paramsMap){
        paramsMap.put("app_key", "b617866c20482d133d5de66fceb37da3");
        paramsMap.put("client_os_type", "4");
        paramsMap.put("nonce", RndStr.getRandomString(10));
        paramsMap.put("timestamp", System.currentTimeMillis()+"");
        paramsMap.put("server_api_version", "1.0.0");
        paramsMap.put("device_id", Device.getAndroidId(context));
        paramsMap.put("sig", Sign.generateSig(paramsMap));
    }

    public static void addCommonParamsEx(Context context,Map<String, String> paramsMap){
        paramsMap.put("app_key", "b617866c20482d133d5de66fceb37da3");
        paramsMap.put("client_os_type", "4");
        paramsMap.put("nonce", RndStr.getRandomString(10));
        paramsMap.put("timestamp", System.currentTimeMillis()+"");
        // paramsMap.put("server_api_version", "1.0.0");
        paramsMap.put("device_id", Device.getAndroidId(context));
        paramsMap.put("sig", Sign.generateSig(paramsMap));
    }

}
