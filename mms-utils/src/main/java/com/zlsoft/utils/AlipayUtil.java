package com.zlsoft.utils;

//import com.alipay.api.AlipayApiException;
//import com.alipay.api.AlipayClient;
//import com.alipay.api.DefaultAlipayClient;
//import com.alipay.api.request.AlipayOpenPublicTemplateMessageIndustryModifyRequest;
//import com.alipay.api.response.AlipayOpenPublicTemplateMessageIndustryModifyResponse;
//import org.springframework.beans.factory.annotation.Value;

import java.io.UnsupportedEncodingException;

public class AlipayUtil {

//    @Value("${alipay.app_id}")
//    private String APP_ID;
//
//    @Value("${alipay.merchant_private_key}")
//    private String APP_PRIVATE_KEY;
//
//    @Value("${alipay.alipay_public_key}")
//    private String ALIPAY_PUBLIC_KEY;
//
//    @Value("${alipay.notify_url}")
//    private String notify_url;
//
//    @Value("${alipay.return_url}")
//    private String return_url;
//
//    @Value("${alipay.sign_type}")
//    private String SIGN_TYPE;
//
//    @Value("${alipay.charset}")
//    private String CHARSET;
//
//    @Value("${alipay.gateway_url}")
//    private String GATEWAY_URL;
//
//    @Value("${alipay.log_path}")
//    private String log_path;
//
//    public void pay(String tradeNo, double totalAmount, String subject, String body) throws AlipayApiException, UnsupportedEncodingException {
//
//        //实例化客户端
//        AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, APP_ID, APP_PRIVATE_KEY, "json", CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE);
//        //实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.open.public.template.message.industry.modify
//        AlipayOpenPublicTemplateMessageIndustryModifyRequest request = new AlipayOpenPublicTemplateMessageIndustryModifyRequest();
//        //SDK已经封装掉了公共参数，这里只需要传入业务参数
//
//        //商户订单号，商户网站订单系统中唯一订单号，必填
//        String out_trade_no = new String(tradeNo.getBytes("ISO-8859-1"),"UTF-8");
//        //付款金额，必填
//        String total_amount = new String(String.valueOf(totalAmount).getBytes("ISO-8859-1"),"UTF-8");
//        //订单名称，必填
//        String wid_subject = new String(subject.getBytes("ISO-8859-1"),"UTF-8");
//        //商品描述，可空
//        String wid_body = new String(body.getBytes("ISO-8859-1"),"UTF-8");
//
//        request.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
//                + "\"total_amount\":\""+ total_amount +"\","
//                + "\"subject\":\""+ subject +"\","
//                + "\"body\":\""+ body +"\","
//                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
//
//        AlipayOpenPublicTemplateMessageIndustryModifyResponse response = alipayClient.execute(request);
//        //调用成功，则处理业务逻辑
//        if (response.isSuccess()) {
//            //.....
//        }
//    }
}
