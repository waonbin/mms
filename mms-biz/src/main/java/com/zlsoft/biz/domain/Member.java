package com.zlsoft.biz.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "m_member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="id_generator")
    @TableGenerator(name = "id_generator",
            table="m_id",
            pkColumnName="pk_name",
            valueColumnName="pk_value",
            pkColumnValue="member_pk",
            initialValue = 10000,
            allocationSize=1
    )
    private Long id;

    /**
     * 邮箱
     */
    @Column(length = 64)
    private String email;

    /**
     * 密码
     */
    @Column(length = 64)
    private String password;

    /**
     * 会员名称
     */
    @Column(length = 64)
    private String name;

    /**
     * 会员类型（字典）
     */
    @Column
    private short memberType;

    /**
     * 手机号码
     */
    @Column(length = 11)
    private String mobile;

    /**
     * 推荐单位（字典）
     */
    @Column
    private short reference;

    /**
     * 性别（字典）
     */
    @Column
    private short gender;

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
    @Column
    private String nationality;

    /**
     * 党派（字典）
     */
    @Column
    private short partisan;

    /**
     * 专业
     */
    @Column(length = 64)
    private String major;

    /**
     * 学历
     */
    @Column(length = 64)
    private String education;

    /**
     * 研究领域
     */
    @Column(length = 64)
    private String researchField;

    /**
     * 已有会员号
     */
    @Column(length = 64)
    private String memberNo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getMemberType() {
        return memberType;
    }

    public void setMemberType(short memberType) {
        this.memberType = memberType;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public short getReference() {
        return reference;
    }

    public void setReference(short reference) {
        this.reference = reference;
    }

    public short getGender() {
        return gender;
    }

    public void setGender(short gender) {
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

    public short getPartisan() {
        return partisan;
    }

    public void setPartisan(short partisan) {
        this.partisan = partisan;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
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
}
