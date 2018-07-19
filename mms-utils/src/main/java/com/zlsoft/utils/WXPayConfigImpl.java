package com.zlsoft.utils;

import com.github.wxpay.sdk.IWXPayDomain;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class WXPayConfigImpl extends com.github.wxpay.sdk.WXPayConfig{

    private byte[] certData;
    private static WXPayConfigImpl INSTANCE;

    private String appID;

    private String mchID;

    private String key;

    public WXPayConfigImpl() throws Exception {
    }

//暂时不需要证书
//    private WXPayConfigImpl() throws Exception{
//        String certPath = "D://CERT/common/apiclient_cert.p12";
//        File file = new File(certPath);
//        InputStream certStream = new FileInputStream(file);
//        this.certData = new byte[(int) file.length()];
//        certStream.read(this.certData);
//        certStream.close();
//    }

    public static WXPayConfigImpl getInstance() throws Exception{
        if (INSTANCE == null) {
            synchronized (WXPayConfigImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new WXPayConfigImpl();
                }
            }
        }
        return INSTANCE;
    }



    public void setAppID(String appID) {
        this.appID = appID;
    }

    public String getAppID() {
        return appID;
//        return "wxcfa32bdbcca4cdfa";
    }


    public void setMchID(String mchID) {
        this.mchID = mchID;
    }

    public String getMchID() {
        return mchID;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public InputStream getCertStream() {
        ByteArrayInputStream certBis;
        certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }


    public int getHttpConnectTimeoutMs() {
        return 3*1000;//调用微信统一下单最长时间限制
    }

    public int getHttpReadTimeoutMs() {
        return 10000;
    }

    public IWXPayDomain getWXPayDomain() {
        return WXPayDomainSimpleImpl.instance();
    }

    public String getPrimaryDomain() {
        return "api.mch.weixin.qq.com";
    }

    public String getAlternateDomain() {
        return "api2.mch.weixin.qq.com";
    }

    @Override
    public int getReportWorkerNum() {
        return 1;
    }

    @Override
    public int getReportBatchSize() {
        return 2;
    }
}