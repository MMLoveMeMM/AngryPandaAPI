package ximalayaos.net.sign;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Mac;

import ximalayaos.net.utils.MD5;

public class Signature {
	private static final String DEFAULT_ENCODING = "UTF-8";
	private static final String HMAC_SHA1 = "HmacSHA1";
	
	/**
	 * 计算参数的签名值 demo
	 * @param paramsMap 所有的参数Map
	 * @param hashkey 如果是服务端接入参数是app_secret+server_static_key，客户端是app_secret
	 * @return
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 * @throws UnsupportedEncodingException 
	 */
	public static String caculateSignature(Map<String, String> paramsMap, String hashkey) throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException {
		if(paramsMap == null || paramsMap.isEmpty() || TextUtils.isEmpty(hashkey)) {
			throw new IllegalArgumentException("paramsMap and seed should not empty");
		}
		
		if(!(paramsMap instanceof TreeMap<?, ?>)) {
			paramsMap = new TreeMap<String, String> (paramsMap);
		}
		StringBuilder paramsBuilder = new StringBuilder();
		for(Map.Entry<String, String> entry: paramsMap.entrySet()) {
			paramsBuilder.append(entry.getKey());
			paramsBuilder.append("=");
			paramsBuilder.append(entry.getValue());
			paramsBuilder.append("&");
		}
		paramsBuilder.deleteCharAt(paramsBuilder.length()-1);
		String paramsEncodedStr = base64Encode(paramsBuilder.toString());
		String sig = hmacSHA1ToStr(paramsEncodedStr, hashkey);
		return sig;
	}

	/**
	 * HMAC SHA1签名或摘要算法
	 * @param data
	 * @param key
	 * @return
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 */
	private static String hmacSHA1ToStr(String data, String key) throws InvalidKeyException, NoSuchAlgorithmException {
		if(data == null || key == null) {
			return null;
		}
		return hmacSHA1ToStr(data.getBytes(), key.getBytes());
	}

		/**
	 * HMAC SHA1签名或摘要算法
	 * @param data 待摘要的字节数据
	 * @param key  使用的key
	 * @return
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 */
	private static String hmacSHA1ToStr(byte[] data, byte[] key) throws NoSuchAlgorithmException, InvalidKeyException  {
		return MD5.md5Hex(hmacSHA1(data, key));
	}

	private static byte[] hmacSHA1(byte[] data, byte[] key) throws NoSuchAlgorithmException, InvalidKeyException {
		if(data == null || key == null) {
			return null;
		}
		
		SecretKeySpec signingKey = new SecretKeySpec(key, HMAC_SHA1);
		Mac mac = Mac.getInstance(HMAC_SHA1);
		mac.init(signingKey);
		return mac.doFinal(data);
	}

	/**
	 * Base64编码
	 * @param data 字符串数据
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	private static String base64Encode(String data) throws UnsupportedEncodingException {
		if(data == null) {
			return null;
		}
		return Base64.encodeToString(data.getBytes(DEFAULT_ENCODING), Base64.NO_WRAP);
	}


}
