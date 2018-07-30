package com.zlsoft.domain;

import com.zlsoft.utils.domain.AbstractBaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "d_member")
public class Member extends AbstractBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="member_id_generator")
    @TableGenerator(name = "member_id_generator",
            table="m_id",
            pkColumnName="pk_name",
            valueColumnName="pk_value",
            pkColumnValue="member_pk",
            initialValue = 10000,
            allocationSize=1
    )
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 邮箱
     */
    @Column(length = 64)
    private String email;

    /**
     * 会员名称
     */
    @Column(length = 64)
    private String name;

    /**
     * 会员类型（字典）
     */
    private Short memberType;

    /**
     * 手机号码
     */
    @Column(length = 11)
    private String mobile;

    /**
     * 推荐单位（字典）
     */
    private Short reference;

    /**
     * 性别（字典）
     */
    private Short gender;

    /**
     * 出生日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    /**
     * 工作单位
     */
    @Column(length = 64)
    private String company;

    /**
     * 职称
     */
    @Column(length = 64)
    private String title;

    /**
     * 民族
     */
    @Column(length = 64)
    private String nationality;

    /**
     * 党派（字典）
     */
    private Short partisan;

    /**
     * 所学专业
     */
    @Column(length = 64)
    private String major;

    /**
     * 工作专业
     */
    @Column(length = 64)
    private String workajor;

    /**
     * 学历
     */
    private Short education;

    /**
     * 等级
     */
    private Short level;

    /**
     * 微信
     */
    @Column(length = 64)
    private String wechat;

    /**
     * QQ
     */
    @Column(length = 32)
    private String oicq;

    /**
     * 传真
     */
    @Column(length = 16)
    private String fax;

    /**
     * 办公电话
     */
    @Column(length = 16)
    private String telephone;

    /**
     * 邮编
     */
    @Column(length = 6)
    private String zipcode;

    /**
     * 省（字典）
     */
    private Short province;

    /**
     * 市（字典）
     */
    private Short city;

    /**
     * 地址
     */
    @Column(length = 128)
    private String address;

    /**
     * 通讯地址
     */
    @Column(length = 256)
    private String fullAddress;

    /**
     * 研究领域
     */
    @Column(length = 64)
    private String researchField;

    /**
     * 会员号
     */
    @Column(length = 64)
    private String memberNo;

    /**
     * 已有会员号
     */
    @Column(length = 64)
    private String existMemberNo;

    /**
     * 毕业学校
     */
    @Column(length = 64)
    private String school;

    /**
     * 工作性质（字典）
     */
    private Short workNature;

    /**
     * 工作业绩
     */
    @Column(length = 512)
    private String jobPerformance;

    /**
     * 会员有效期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date expiryDate;

    /**
     * 会员状态（字典）
     */
    @Column(name = "member_status")
    private Short status;

    /**
     * 入会年份
     */
    @Column(length = 4)
    private String admitYear;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getMemberType() {
        return memberType;
    }

    public void setMemberType(Short memberType) {
        this.memberType = memberType;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Short getReference() {
        return reference;
    }

    public void setReference(Short reference) {
        this.reference = reference;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Short getPartisan() {
        return partisan;
    }

    public void setPartisan(Short partisan) {
        this.partisan = partisan;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getWorkajor() {
        return workajor;
    }

    public void setWorkajor(String workajor) {
        this.workajor = workajor;
    }

    public Short getEducation() {
        return education;
    }

    public void setEducation(Short education) {
        this.education = education;
    }

    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getOicq() {
        return oicq;
    }

    public void setOicq(String oicq) {
        this.oicq = oicq;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Short getProvince() {
        return province;
    }

    public void setProvince(Short province) {
        this.province = province;
    }

    public Short getCity() {
        return city;
    }

    public void setCity(Short city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getResearchField() {
        return researchField;
    }

    public void setResearchField(String researchField) {
        this.researchField = researchField;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public String getExistMemberNo() {
        return existMemberNo;
    }

    public void setExistMemberNo(String existMemberNo) {
        this.existMemberNo = existMemberNo;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Short getWorkNature() {
        return workNature;
    }

    public void setWorkNature(Short workNature) {
        this.workNature = workNature;
    }

    public String getJobPerformance() {
        return jobPerformance;
    }

    public void setJobPerformance(String jobPerformance) {
        this.jobPerformance = jobPerformance;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getAdmitYear() {
        return admitYear;
    }

    public void setAdmitYear(String admitYear) {
        this.admitYear = admitYear;
    }
}
