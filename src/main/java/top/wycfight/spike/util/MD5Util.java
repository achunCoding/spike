package top.wycfight.spike.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author: wycfight@163.com
 * @description: MD5工具类
 * @create: 2019-12-04 21:28
 * @modify By:
 **/
public class MD5Util {

    private static String salt = "1a2b3c4d";
    /**
     * MD5加密
     * @param password
     * @return
     */
    private static String md5(String password) {
        return DigestUtils.md5Hex(password);
    }

    public static String inputPassToFormPass(String inputPass) {
        String str = salt.charAt(0) + salt.charAt(1) +  inputPass + salt.charAt(5) + salt.charAt(3);
        return md5(str);
    }

    public static String formPassToDbPass(String formPass, String salt) {
        String str = salt.charAt(0) + salt.charAt(1) +  formPass + salt.charAt(5) + salt.charAt(3);
        return md5(str);
    }

    public static String inputPassToDbPass(String inputPass, String salt) {
        String formPass = inputPassToFormPass(inputPass);
        return formPassToDbPass(formPass, salt);
    }

    public static void main(String[] args) {
        System.out.println(inputPassToFormPass("123456"));
    }


}
