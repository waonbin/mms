package com.zlsoft.utils;

import com.github.wxpay.sdk.IWXPayDomain;

import java.io.InputStream;

public class WechatPayConfig extends com.github.wxpay.sdk.WXPayConfig {

    private static WechatPayConfig INSTANCE;

    private WechatPayConfig() {
    }

    public static WechatPayConfig getInstance() {
        if (INSTANCE == null) {
            synchronized (WechatPayConfig.class) {
                if (INSTANCE == null) {
                    INSTANCE = new WechatPayConfig();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public String getAppID() {
        return "wxa5f7a37b2d85c419";
    }

    @Override
    public String getMchID() {
        return "1501344151";
    }

    @Override
    public String getKey() {
        return "C8LaZ3Fq4h3CK8LW2gxPdto7NQ6yTfXD";
    }

    @Override
    public InputStream getCertStream() {
        return null;
    }

    @Override
    public IWXPayDomain getWXPayDomain() {
        return WechatPayDomain.instance();
    }
}
