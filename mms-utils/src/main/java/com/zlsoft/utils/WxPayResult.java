package com.zlsoft.utils;

public class WxPayResult {

    /**
     * 返回状态码
     * String(16)
     * SUCCESS/FAIL
     * 此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
     */
    private String returnCode;

    /**
     * 返回信息
     * String(128)
     * 当return_code为FAIL时返回信息为错误原因 ，例如：
     *   签名失败
     *   参数格式校验错误
     */
    private String returnMsg;

    //以下字段在return_code为SUCCESS的时候有返回

    /**
     * 公众账号ID
     * String(32)
     * 调用接口提交的公众账号ID
     */
    private String appid;

    /**
     * 商户号
     * String(32)
     * 调用接口提交的商户号
     */
    private String mchId;

    /**
     * 设备号
     * String(32)
     * 自定义参数，可以为请求支付的终端设备号等
     */
    private String deviceInfo;

    /**
     * 随机字符串
     * String(32)
     * 微信返回的随机字符串
     */
    private String nonceStr;

    /**
     * 签名
     * String(32)
     * 微信返回的签名值
     */
    private String sign;

    /**
     * 业务结果
     * String(16)
     * SUCCESS/FAIL
     */
    private String resultCode;

    /**
     * 错误代码
     * String(32)
     * 当result_code为FAIL时返回错误代码
     */
    private String errorCode;

    /**
     * 错误代码描述
     * String(128)
     * 当result_code为FAIL时返回错误描述
     */
    private String errorCodeDes;

    //以下字段在return_code 和result_code都为SUCCESS的时候有返回

    /**
     * 交易类型
     * String(16)
     *   JSAPI 公众号支付
     *   NATIVE 扫码支付
     *   APP APP支付
     */
    private String tradeType;

    /**
     * 预支付交易会话标识
     * String(64)
     * 微信生成的预支付会话标识，用于后续接口调用中使用，该值有效期为2小时
     */
    private String prepayId;

    /**
     * 二维码链接
     * String(64)
     * trade_type为NATIVE时有返回，用于生成二维码，展示给用户进行扫码支付
     */
    private String codeUrl;

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCodeDes() {
        return errorCodeDes;
    }

    public void setErrorCodeDes(String errorCodeDes) {
        this.errorCodeDes = errorCodeDes;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getPrepayId() {
        return prepayId;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }
}
