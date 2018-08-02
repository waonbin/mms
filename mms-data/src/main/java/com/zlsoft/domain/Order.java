package com.zlsoft.domain;

import com.zlsoft.utils.domain.AbstractBaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "d_order")
public class Order extends AbstractBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="order_id_generator")
    @TableGenerator(name = "order_id_generator",
            table="m_id",
            pkColumnName="pk_name",
            valueColumnName="pk_value",
            pkColumnValue="order_pk",
            initialValue = 10000,
            allocationSize=1
    )
    private Long id;

    /**
     * 订单编号
     */
    @Column(length = 16)
    private String orderNo;

    /**
     * 会员编号
     */
    private Long memberId;

    /**
     * 订单类型（字典）
     */
    private Short orderType;

    /**
     * 订单金额
     */
    private Double orderAmount;

    /**
     * 支付状态（字典）
     */
    private Short payStatus;

    /**
     * 支付类型（字典）
     */
    private Short payType;

    /**
     * 线上支付类型（字典）
     */
    private Short onlineType;

    /**
     * 线下支付凭证（上传文件ID）
     */
    private Long offlineVoucher;

    /**
     * 支付时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date payTime;

    /**
     * 发票信息
     */
    private Long invoiceId;

    /**
     * （收件人）姓名
     */
    @Column(length = 64)
    private String recipients;

    /**
     * （收件人）手机号码
     */
    @Column(length = 11)
    private String recipientsMobile;

    /**
     * （收件人）省（字典）
     */
    private Short recipientsProvince;

    /**
     * （收件人）市（字典）
     */
    private Short recipientsCity;

    /**
     * （收件人）地址
     */
    @Column(length = 128)
    private String recipientsAddress;

    /**
     * （收件人）地址
     */
    @Column(length = 256)
    private String recipientsFullAddress;

    /**
     * （收件人）邮编
     */
    @Column(length = 6)
    private String recipientsZipcode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Short getOrderType() {
        return orderType;
    }

    public void setOrderType(Short orderType) {
        this.orderType = orderType;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Short getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Short payStatus) {
        this.payStatus = payStatus;
    }

    public Short getPayType() {
        return payType;
    }

    public void setPayType(Short payType) {
        this.payType = payType;
    }

    public Short getOnlineType() {
        return onlineType;
    }

    public void setOnlineType(Short onlineType) {
        this.onlineType = onlineType;
    }

    public Long getOfflineVoucher() {
        return offlineVoucher;
    }

    public void setOfflineVoucher(Long offlineVoucher) {
        this.offlineVoucher = offlineVoucher;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getRecipients() {
        return recipients;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients;
    }

    public String getRecipientsMobile() {
        return recipientsMobile;
    }

    public void setRecipientsMobile(String recipientsMobile) {
        this.recipientsMobile = recipientsMobile;
    }

    public Short getRecipientsProvince() {
        return recipientsProvince;
    }

    public void setRecipientsProvince(Short recipientsProvince) {
        this.recipientsProvince = recipientsProvince;
    }

    public Short getRecipientsCity() {
        return recipientsCity;
    }

    public void setRecipientsCity(Short recipientsCity) {
        this.recipientsCity = recipientsCity;
    }

    public String getRecipientsAddress() {
        return recipientsAddress;
    }

    public void setRecipientsAddress(String recipientsAddress) {
        this.recipientsAddress = recipientsAddress;
    }

    public String getRecipientsFullAddress() {
        return recipientsFullAddress;
    }

    public void setRecipientsFullAddress(String recipientsFullAddress) {
        this.recipientsFullAddress = recipientsFullAddress;
    }

    public String getRecipientsZipcode() {
        return recipientsZipcode;
    }

    public void setRecipientsZipcode(String recipientsZipcode) {
        this.recipientsZipcode = recipientsZipcode;
    }
}
