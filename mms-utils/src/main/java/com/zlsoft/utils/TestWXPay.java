package com.zlsoft.utils;

import com.github.wxpay.sdk.WXPay;

import java.util.HashMap;
import java.util.Map;

public class TestWXPay {

    private WXPay wxpay;
    private WechatPayConfig config;
    private String out_trade_no;
    private String total_fee;

    public TestWXPay() throws Exception {
        config = WechatPayConfig.getInstance();
        wxpay = new WXPay(config);
        total_fee = "0.01";
        // out_trade_no = "201701017496748980290321";
        out_trade_no = "20171309105959000000343348fw4";
    }

    /**
     * 扫码支付  下单
     */
    public void doUnifiedOrder() {

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

        try {
            Map<String, String> resp = wxpay.unifiedOrder(data);
            System.out.println(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        HashMap<String, String> data = new HashMap<String, String>();
//        data.put("body", "充值0.01元");
//        data.put("out_trade_no", out_trade_no);
//        data.put("device_info", "WEB");
//        data.put("fee_type", "CNY");
//        data.put("total_fee", "0.01");
//        data.put("spbill_create_ip", "123.12.12.123");
//        data.put("notify_url", "http://test.letiantian.me/wxpay/notify");
//        data.put("trade_type", "NATIVE");
//        data.put("product_id", "fmwijfief4648584488484848484");
//        // data.put("time_expire", "20170112104120");
//
//        try {
//            Map<String, String> r = wxpay.unifiedOrder(data);
//            System.out.println(r);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }


    public static void main(String[] args) throws Exception {
        System.out.println("--------------->");
        TestWXPay dodo = new TestWXPay();
        System.out.println("-----了之咯--------");
        dodo.doUnifiedOrder();
        System.out.println("<---------------"); // wx2016112510573077
    }
}