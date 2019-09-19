package ximalayaos.net.utils;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: HMacSHA1
 * @Author: 刘志保
 * @CreateDate: 2019/9/17 9:06
 * @Description: Hmac_SHA1加密方式
 */
public class HMacSHA1 {

    private static final String HMAC_SHA1 = "HmacSHA1";
    public static byte[] hmacSHA1(byte[] data, byte[] key) throws NoSuchAlgorithmException, InvalidKeyException {
        if (data == null || key == null) {
            return null;
        }

        SecretKeySpec signingKey = new SecretKeySpec(key, HMAC_SHA1);
        Mac mac = Mac.getInstance(HMAC_SHA1);
        mac.init(signingKey);
        return mac.doFinal(data);
    }

}
