package com.zlsoft.utils;

import com.github.wxpay.sdk.IWXPayDomain;

import java.io.InputStream;

public class WechatPayConfig extends com.github.wxpay.sdk.WXPayConfig {

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
        return "f8e4c5603b328bffc729f84a305ff89b";
    }

    @Override
    public InputStream getCertStream() {
        return null;
    }

    @Override
    public IWXPayDomain getWXPayDomain() {
        return null;
    }
}
