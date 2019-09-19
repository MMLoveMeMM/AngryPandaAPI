package ximalayaos.net.sign;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: AngryPandaRetrofit
 * @ClassName: Sig
 * @Author: 刘志保
 * @CreateDate: 2019/9/16 10:37
 * @Description: java类作用描述
 */
public class Sign {

    private static final String TAG = Sign.class.getName();
    private static String appSecret = "4d8e605fa7ed546c4bcb33dee1381179";
    private static String serverAuthStaticKey = "z0hh5l9A";
    private static String hashKey = appSecret + serverAuthStaticKey;

    public static String generateSig(Map<String, String> hashMap) {
        Map<String, String> tMap = new HashMap<>();
        List<String> lists = new ArrayList<>();
        List<String> list1s = new ArrayList<>();
        String lstr[] = new String[100];

        StringBuilder sb = new StringBuilder();
        for (String key : hashMap.keySet()) {
            sb.append("&" + key + "=" + hashMap.get(key));
            lists.add(key);
        }

        if (lists != null && lists.size() > 0) {
            Collections.sort(lists);
        }

        int index = 0;
        for (String key : lists) {
            lstr[++index] = key;
        }

        for (int i = index; i > 0; i--) {
            list1s.add(lstr[i]);
        }

        for (String key : list1s) {
            tMap.put(key, hashMap.get(key));
        }

        try {
            String sig = Signature.caculateSignature(tMap, hashKey);
            Log.e(TAG, "SIG后 : " + sig);
            return sig;
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String showBody(Map<String, String> bodyMap) {
        StringBuilder sb = new StringBuilder();
        for (String key : bodyMap.keySet()) {
            sb.append("&" + key + "=" + bodyMap.get(key));
        }
        String query_str = sb.toString();
        query_str = query_str.substring(1, query_str.length());
        return query_str;
    }

}
