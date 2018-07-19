package com.zlsoft.utils;

import com.github.wxpay.sdk.WXPay;

import java.util.HashMap;
import java.util.Map;

public class TestWXPay {

    private WXPay wxpay;
    private WXPayConfigImpl config;
    private String out_trade_no;
    private String total_fee;

    public TestWXPay() throws Exception {
        config = WXPayConfigImpl.getInstance();
        config.setAppID("wxa5f7a37b2d85c419");//自己的AppID
        config.setMchID("1501344151");//自己的MchId
        config.setKey("f8e4c5603b328bffc729f84a305ff89b");//自己的Appkey
        wxpay = new WXPay(config);
        total_fee = "0.01";
        // out_trade_no = "201701017496748980290321";
        out_trade_no = "20171309105959000000343348fw4";
    }

    /**
     * 扫码支付  下单
     */
    public void doUnifiedOrder() {
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("body", "充值0.01元");
        data.put("out_trade_no", out_trade_no);
        data.put("device_info", "WEB");
        data.put("fee_type", "CNY");
        data.put("total_fee", "0.01");
        data.put("spbill_create_ip", "123.12.12.123");
        data.put("notify_url", "http://test.letiantian.me/wxpay/notify");
        data.put("trade_type", "NATIVE");
        data.put("product_id", "fmwijfief4648584488484848484");
        // data.put("time_expire", "20170112104120");

        try {
            Map<String, String> r = wxpay.unifiedOrder(data);
            System.out.println(r);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        System.out.println("--------------->");
        TestWXPay dodo = new TestWXPay();
        System.out.println("-----了之咯--------");
        dodo.doUnifiedOrder();
        System.out.println("<---------------"); // wx2016112510573077
    }
}