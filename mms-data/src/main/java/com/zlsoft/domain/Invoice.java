package com.zlsoft.domain;

import javax.persistence.*;

@Entity
@Table(name = "d_invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="invoice_id_generator")
    @TableGenerator(name = "invoice_id_generator",
            table="m_id",
            pkColumnName="pk_name",
            valueColumnName="pk_value",
            pkColumnValue="invoice_pk",
            initialValue = 10000,
            allocationSize=1
    )
    private Long id;

    /**
     * 发票类型
     */
    private Short invoiceType;

    /**
     * 抬头类型
     */
    private Short titleType;

    /**
     * 公司名称
     */
    @Column(length = 64)
    private String companyName;

    /**
     * 发票内容
     */
    private Short contentType;

    /**
     * 纳税人识别号
     */
    @Column(length = 18)
    private String tin;

    /**
     * 注册地址
     */
    @Column(length = 128)
    private String address;

    /**
     * 注册电话
     */
    @Column(length = 16)
    private String telephone;

    /**
     * 开户银行
     */
    @Column(length = 64)
    private String bank;

    /**
     * 银行账户
     */
    @Column(length = 18)
    private String account;

    /**
     * 金额
     */
    private Double amount;

    /**
     * 取票方式
     */
    private Short deliveryType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Short invoiceType) {
        this.invoiceType = invoiceType;
    }

    public Short getTitleType() {
        return titleType;
    }

    public void setTitleType(Short titleType) {
        this.titleType = titleType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Short getContentType() {
        return contentType;
    }

    public void setContentType(Short contentType) {
        this.contentType = contentType;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Short getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(Short deliveryType) {
        this.deliveryType = deliveryType;
    }
}
