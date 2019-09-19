package ximalayaos.net.utils;

import android.content.Context;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: Device
 * @Author: 刘志保
 * @CreateDate: 2019/9/17 9:03
 * @Description: 获取设备ID
 */
public class Device {
    public static String getAndroidId(Context context) {
        return android.provider.Settings.Secure.getString(
                context.getContentResolver(),
                android.provider.Settings.Secure.ANDROID_ID);
    }
}
