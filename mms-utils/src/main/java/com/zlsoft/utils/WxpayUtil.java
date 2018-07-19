package com.zlsoft.utils;

import com.github.wxpay.sdk.WXPay;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class WxpayUtil {

    public static void pay() throws Exception {

        com.github.wxpay.sdk.WXPayConfig config = new WXPayConfig();
        WXPay wxpay = new WXPay(config);

        Map<String, String> data = new HashMap<>();
        data.put("body", "腾讯充值中心-QQ会员充值");
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
    }

    public static void main(String[] args) throws Exception {

        String parameter = "<xml>\n" +
                "   <appid>wxa5f7a37b2d85c419</appid>\n" +
                "   <attach>支付测试</attach>\n" +
                "   <body>JSAPI支付测试</body>\n" +
                "   <mch_id>1501344151</mch_id>\n" +
                "   <detail><![CDATA[{ \"goods_detail\":[ { \"goods_id\":\"iphone6s_16G\", \"wxpay_goods_id\":\"1001\", \"goods_name\":\"iPhone6s 16G\", \"quantity\":1, \"price\":528800, \"goods_category\":\"123456\", \"body\":\"苹果手机\" }, { \"goods_id\":\"iphone6s_32G\", \"wxpay_goods_id\":\"1002\", \"goods_name\":\"iPhone6s 32G\", \"quantity\":1, \"price\":608800, \"goods_category\":\"123789\", \"body\":\"苹果手机\" } ] }]]></detail>\n" +
                "   <nonce_str>1add1a30ac87aa2db72f57a2375d8fec</nonce_str>\n" +
                "   <notify_url>http://wxpay.wxutil.com/pub_v2/pay/notify.v2.php</notify_url>\n" +
                "   <openid>oUpF8uMuAJO_M2pxb1Q9zNjWeS6o</openid>\n" +
                "   <out_trade_no>1415659990</out_trade_no>\n" +
                "   <spbill_create_ip>14.23.150.211</spbill_create_ip>\n" +
                "   <total_fee>0.01</total_fee>\n" +
                "   <trade_type>JSAPI</trade_type>\n" +
                "   <sign>0CB01533B8C1EF103065174F50BCA001</sign>\n" +
                "</xml>";

        RestTemplate template = new RestTemplate();
        template.postForObject("https://api.mch.weixin.qq.com/pay/unifiedorder", "", String.class);
    }
}
