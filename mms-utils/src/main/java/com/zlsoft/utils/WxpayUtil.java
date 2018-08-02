package com.zlsoft.utils;

import com.github.wxpay.sdk.WXPay;

import java.util.HashMap;
import java.util.Map;

public class WxPayUtil {

    public static WxPayResult pay() {

        try {
            WechatPayConfig config = WechatPayConfig.getInstance();
            WXPay wxPay = new WXPay(config);

            Map<String, String> data = new HashMap<String, String>();
            data.put("body", "test");
            data.put("out_trade_no", "2016090910595900000012");
            data.put("device_info", "");
            data.put("fee_type", "CNY");
            data.put("total_fee", "1");
            data.put("spbill_create_ip", "123.12.12.123");
            data.put("notify_url", "http://www.example.com/wxpay/notify");
            data.put("trade_type", "NATIVE");  // 此处指定为扫码支付
            data.put("product_id", "12");

            Map<String, String> resp = wxPay.unifiedOrder(data);

            return convert(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
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
            result.setPrepayId(resp.get("code_url"));
        }

        return  result;
    }
}
