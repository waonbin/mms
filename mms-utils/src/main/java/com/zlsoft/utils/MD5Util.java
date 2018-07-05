package com.zlsoft.utils;

import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;

public class MD5Util {

    public static String getMD5WithBase64(String message) {

        String result = "";

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte md5[] = md.digest(message.getBytes());
            result = Base64.encodeBase64String(md5);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
