package com.zlsoft.utils;

import com.github.wxpay.sdk.IWXPayDomain;
import com.github.wxpay.sdk.WXPayConfig;

public class WXPayDomainSimpleImpl implements IWXPayDomain {

    private static IWXPayDomain instance = null;

    public static IWXPayDomain instance() {

        if(instance == null) {
            instance = new WXPayDomainSimpleImpl();
        }

        return instance;
    }

    @Override
    public void report(String domain, long elapsedTimeMillis, Exception ex) {

    }

    @Override
    public DomainInfo getDomain(WXPayConfig config) {
        return null;
    }
}
