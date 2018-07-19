package com.zlsoft.utils;

import com.github.wxpay.sdk.IWXPayDomain;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class WXPayConfig extends com.github.wxpay.sdk.WXPayConfig{

    private byte[] certData = null;

    public WXPayConfig() throws Exception {
//        String certPath = "/path/to/apiclient_cert.p12";
//        File file = new File(certPath);
//        InputStream certStream = new FileInputStream(file);
//        this.certData = new byte[(int) file.length()];
//        certStream.read(this.certData);
//        certStream.close();
    }

    /**
     * 公众账号ID
     * @return
     */
    @Override
    public String getAppID() {
        return "wxa5f7a37b2d85c419";
    }

    /**
     * 商户号
     * @return
     */
    @Override
    public String getMchID() {
        return "1501344151";
    }

    /**
     * API密钥
     * @return
     */
    @Override
    public String getKey() {
        return "f8e4c5603b328bffc729f84a305ff89b";
    }

    /**
     * 商户证书内容
     * @return
     */
    @Override
    public InputStream getCertStream() {
        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }

    /**
     * HTTP(S) 连接超时时间，单位毫秒
     * @return
     */
    @Override
    public int getHttpConnectTimeoutMs() {
        return 8000;
    }

    /**
     * HTTP(S) 读数据超时时间，单位毫秒
     * @return
     */
    @Override
    public int getHttpReadTimeoutMs() {
        return 10000;
    }

    /**
     * WXPayDomain, 用于多域名容灾自动切换
     * @return
     */
    @Override
    public IWXPayDomain getWXPayDomain() {
        return null;
    }
}
