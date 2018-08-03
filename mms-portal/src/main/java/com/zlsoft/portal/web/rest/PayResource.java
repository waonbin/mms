package com.zlsoft.portal.web.rest;

import com.github.wxpay.sdk.WXPayUtil;
import com.zlsoft.common.service.OrderService;
import com.zlsoft.domain.Order;
import com.zlsoft.utils.WxPayParam;
import com.zlsoft.utils.WxPayResult;
import com.zlsoft.utils.WxPayUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Optional;
import java.util.SortedMap;
import java.util.TreeMap;

@RestController
public class PayResource {

    @Inject
    private OrderService orderService;

    @Value("${wxpay.notifyUrl}")
    private String notifyUrl;

    @PostMapping("/wxpay/membership/pay")
    public ResponseEntity pay(String body, String orderNo, double totalFee) {

        WxPayParam param = new WxPayParam();
        String productId = "01";

        param.setBody(body);
        param.setOutTradeNo(orderNo);
        param.setProductId(productId);
        param.setTotalFee(String.valueOf((int)(totalFee * 100)));
        param.setTradeType("NATIVE");
        param.setNotifyUrl(notifyUrl);
        param.setFeeType("CNY");
        param.setSpbillCreateIp(WxPayUtil.getLocalIP());

        WxPayResult result = WxPayUtil.pay(param);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/wxpay/notify")
    public String wxpayNotify(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");

        //回去支付接口返回值
        StringBuffer inputString = new StringBuffer();
        String line;
        while ((line = request.getReader().readLine()) != null) {
            inputString.append(line);
        }
        request.getReader().close();
        String notityXml = inputString.toString();

        //验证签名
        if(!WXPayUtil.isSignatureValid(notityXml, "")) {
            return buildResult("FAIL", "签名验证失败");
        }

        //转换为Map
        Map map = WXPayUtil.xmlToMap(notityXml);

        //更新订单状态
        String orderNo = (String)map.get("out_trade_no");
        Optional<Order> optionalOrder = this.orderService.findOneByOrderNo(orderNo);

        if(optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setPayStatus((short)2);
            this.orderService.save(order);
        }

        return buildResult("SUCCESS", "支付成功");
    }

    private static String buildResult(String return_code, String return_msg) {
        SortedMap<String, String> parameters = new TreeMap<>();
        parameters.put("return_code", return_code);
        parameters.put("return_msg", return_msg);
        return "<xml><return_code><![CDATA[" + return_code + "]]>" +
                "</return_code><return_msg><![CDATA[" + return_msg + "]]></return_msg></xml>";
    }
}