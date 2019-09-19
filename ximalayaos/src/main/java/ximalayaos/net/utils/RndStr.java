package ximalayaos.net.utils;

import android.content.Context;

import java.util.Random;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: RndStr
 * @Author: 刘志保
 * @CreateDate: 2019/9/16 12:06
 * @Description: 获取随机字符串
 */
public class RndStr {

    /**
     * 产生一个随机字符串
     * @param length : 产生一个随机字符串长度
     * @return
     */
    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString().toLowerCase();
    }

}
