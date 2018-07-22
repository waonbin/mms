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

        if(payment != null) {
            this.setId(payment.getId());
            this.setOrderNo(payment.getOrderNo());
            this.setMemberId(payment.getMemberId());
            this.setOrderType(payment.getOrderType());
            this.setOrderAmount(payment.getOrderAmount());
            this.setPayStatus(payment.getPayStatus());
            this.setPayType(payment.getPayType());
            this.setOnlineType(payment.getOnlineType());
            this.setOfflineVoucher(payment.getOfflineVoucher());
            this.setPayTime(payment.getPayTime());
        }

        if(member != null) {
            this.setMemberName(member.getName());
            this.setMemberType(member.getMemberType());
            this.setReference(member.getReference());
        }
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Short getMemberType() {
        return memberType;
    }

    public void setMemberType(Short memberType) {
        this.memberType = memberType;
    }

    public Short getReference() {
        return reference;
    }

    public void setReference(Short reference) {
        this.reference = reference;
    }
}
