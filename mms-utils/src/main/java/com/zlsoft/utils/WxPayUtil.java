package com.zlsoft.utils;

import com.github.wxpay.sdk.WXPay;
import com.google.common.base.Strings;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class WxPayUtil {

    private static final String SYMBOLS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final Random RANDOM = new SecureRandom();

    public static WxPayResult pay(WxPayParam param) {

        try {
            WechatPayConfig config = WechatPayConfig.getInstance();
            WXPay wxPay = new WXPay(config);

            Map<String, String> data = new HashMap<String, String>();

            if(!Strings.isNullOrEmpty(param.getAppId())) {
                data.put("appid", param.getAppId());
            }

            if(!Strings.isNullOrEmpty(param.getMchId())) {
                data.put("mch_id", param.getMchId());
            }

            if(!Strings.isNullOrEmpty(param.getDeviceInfo())) {
                data.put("device_info", param.getDeviceInfo());
            }

            if(!Strings.isNullOrEmpty(param.getNonceStr())) {
                data.put("nonce_str", param.getNonceStr());
            }

            if(!Strings.isNullOrEmpty(param.getSign())) {
                data.put("sign", param.getSign());
            }

            if(!Strings.isNullOrEmpty(param.getSignType())) {
                data.put("sign_type", param.getSignType());
            }

            if(!Strings.isNullOrEmpty(param.getBody())) {
                data.put("body", param.getBody());
            }

            if(!Strings.isNullOrEmpty(param.getDetail())) {
                data.put("detail", param.getDetail());
            }

            if(!Strings.isNullOrEmpty(param.getAttach())) {
                data.put("attach", param.getAttach());
            }

            if(!Strings.isNullOrEmpty(param.getOutTradeNo())) {
                data.put("out_trade_no", param.getOutTradeNo());
            }

            if(!Strings.isNullOrEmpty(param.getFeeType())) {
                data.put("fee_type", param.getFeeType());
            }

            if(!Strings.isNullOrEmpty(param.getTotalFee())) {
                data.put("total_fee", param.getTotalFee());
            }

            if(!Strings.isNullOrEmpty(param.getSpbillCreateIp())) {
                data.put("spbill_create_ip", param.getSpbillCreateIp());
            }

            if(!Strings.isNullOrEmpty(param.getTimeStart())) {
                data.put("time_start", param.getTimeStart());
            }

            if(!Strings.isNullOrEmpty(param.getTimeExpire())) {
                data.put("time_expire", param.getTimeExpire());
            }

            if(!Strings.isNullOrEmpty(param.getGoodsTag())) {
                data.put("goods_tag", param.getGoodsTag());
            }

            if(!Strings.isNullOrEmpty(param.getNotifyUrl())) {
                data.put("notify_url", param.getNotifyUrl());
            }

            if(!Strings.isNullOrEmpty(param.getTradeType())) {
                data.put("trade_type", param.getTradeType());
            }

            if(!Strings.isNullOrEmpty(param.getProductId())) {
                data.put("product_id", param.getProductId());
            }

            if(!Strings.isNullOrEmpty(param.getLimitPay())) {
                data.put("limit_pay", param.getLimitPay());
            }

            if(!Strings.isNullOrEmpty(param.getOpenId())) {
                data.put("openid", param.getOpenId());
            }

            if(!Strings.isNullOrEmpty(param.getSceneInfo())) {
                data.put("scene_info", param.getSceneInfo());
            }

            Map<String, String> resp = wxPay.unifiedOrder(data);

            return convert(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 随机生成商户订单号
     * @return 商户订单号
     */
    public static String generateOutTradeNo() {
        StringBuffer orderSNBuffer = new StringBuffer();
        orderSNBuffer.append(System.currentTimeMillis());
        orderSNBuffer.append(getRandomString(7));
        return orderSNBuffer.toString();
    }

    /**
     * 生成随机数
     * @param len 随机数长度
     * @return 随机数
     */
    private static String getRandomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(SYMBOLS.charAt(RANDOM.nextInt(SYMBOLS.length())));
        return sb.toString();
    }

    /**
     * 获得本机ip地址
     * @return 本机ip地址
     */
    public static String getLocalIP() {
        String ip = "";
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return ip;
    }

    /**
     * 转换支付接口返回结构
     * @param resp 接口返回值
     * @return 转换后的值
     */
    private static WxPayResult convert(Map<String, String> resp) {

        if(resp == null) {
            return null;
        }

        WxPayResult result = new WxPayResult();

        if(resp.containsKey("return_code")) {
            result.setReturnCode(resp.get("return_code"));
        }

        if(resp.containsKey("return_msg")) {
            result.setReturnMsg(resp.get("return_msg"));
        }

        if(resp.containsKey("appid")) {
            result.setAppid(resp.get("appid"));
        }

        if(resp.containsKey("mch_id")) {
            result.setMchId(resp.get("mch_id"));
        }

        if(resp.containsKey("device_info")) {
            result.setDeviceInfo(resp.get("device_info"));
        }

        if(resp.containsKey("nonce_str")) {
            result.setNonceStr(resp.get("nonce_str"));
        }

        if(resp.containsKey("sign")) {
            result.setSign(resp.get("sign"));
        }

        if(resp.containsKey("result_code")) {
            result.setResultCode(resp.get("result_code"));
        }

        if(resp.containsKey("err_code")) {
            result.setErrorCode(resp.get("err_code"));
        }

        if(resp.containsKey("err_code_des")) {
            result.setErrorCodeDes(resp.get("err_code_des"));
        }

        if(resp.containsKey("trade_type")) {
            result.setTradeType(resp.get("trade_type"));
        }

        if(resp.containsKey("prepay_id")) {
            result.setPrepayId(resp.get("prepay_id"));
        }

        if(resp.containsKey("code_url")) {
            result.setCodeUrl(resp.get("code_url"));
        }

        return  result;
    }
}
