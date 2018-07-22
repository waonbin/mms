package com.zlsoft.manager.web.vm;

import com.zlsoft.domain.Member;
import com.zlsoft.domain.Payment;

public class OrderVM extends Payment {

    /**
     * 会员名称
     */
    private String memberName;

    /**
     * 会员类型
     */
    private Short memberType;

    /**
     * 推荐单位（字典）
     */
    private Short reference;

    public OrderVM(Payment payment, Member member) {
        this.setId(payment.getId());

    }
}
