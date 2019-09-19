package ximalayaos.net.utils;

import android.util.Log;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: MD5
 * @Author: 刘志保
 * @CreateDate: 2019/9/16 10:35
 * @Description: MD5加密算法
 */
public class MD5 {

    /**
     * @param inputStr
     * @return 32位的MD5数
     */
    public static String transformMD5(String inputStr) {

        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
        char[] charArray = inputStr.toCharArray(); //将字符串转换为字符数组
        byte[] byteArray = new byte[charArray.length]; //创建字节数组

        for (int i = 0; i < charArray.length; i++) {
            byteArray[i] = (byte) charArray[i];
        }

        //将得到的字节数组进行MD5运算
        byte[] md5Bytes = md5.digest(byteArray);

        StringBuffer md5Str = new StringBuffer();

        for (int i = 0; i < md5Bytes.length; i++) {
            if (Integer.toHexString(0xFF & md5Bytes[i]).length() == 1) {
                md5Str.append("0").append(Integer.toHexString(0xFF & md5Bytes[i]));
            } else {
                md5Str.append(Integer.toHexString(0xFF & md5Bytes[i]));
            }
        }

        return md5Str.toString();
    }

    public static String md5Hex(final byte[] data) {
        return encodeHexString(md5(data));
    }

    public static byte[] md5(final byte[] data) {
        return getMd5Digest().digest(data);
    }

    public static final String MD5 = "MD5";

    public static MessageDigest getMd5Digest() {
        return getDigest(MD5);
    }

    public static MessageDigest getDigest(final String algorithm) {
        try {
            return MessageDigest.getInstance(algorithm);
        } catch (final NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String encodeHexString(final byte[] data) {
        return new String(encodeHex(data));
    }

    public static char[] encodeHex(final byte[] data) {
        return encodeHex(data, true);
    }

    private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
            'e', 'f'};

    /**
     * Used to build output as Hex
     */
    private static final char[] DIGITS_UPPER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
            'E', 'F'};

    public static char[] encodeHex(final byte[] data, final boolean toLowerCase) {
        return encodeHex(data, toLowerCase ? DIGITS_LOWER : DIGITS_UPPER);
    }

    protected static char[] encodeHex(final byte[] data, final char[] toDigits) {
        final int l = data.length;
        final char[] out = new char[l << 1];
        // two characters form the hex value.
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = toDigits[(0xF0 & data[i]) >>> 4];
            out[j++] = toDigits[0x0F & data[i]];
        }
        return out;
    }

}
