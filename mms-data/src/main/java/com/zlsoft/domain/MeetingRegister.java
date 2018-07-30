package com.zlsoft.domain;

import com.zlsoft.utils.domain.AbstractBaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "d_meeting_register")
public class MeetingRegister extends AbstractBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="mtg_register_id_generator")
    @TableGenerator(name = "mtg_register_id_generator",
            table="m_id",
            pkColumnName="pk_name",
            valueColumnName="pk_value",
            pkColumnValue="mtg_register_pk",
            initialValue = 10000,
            allocationSize=1
    )
    private Long id;

    /**
     * 会议id
     */
    private Long meetingId;

    /**
     * 姓名
     */
    @Column(length = 64)
    private String name;

    /**
     * 性别（字典）
     */
    private Short gender;

    /**
     * 出生日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Instant birthday;

    /**
     * 职务/职称
     */
    @Column(length = 64)
    private String title;

    /**
     * 手机号码
     */
    @Column(length = 11)
    private String mobile;

    /**
     * 邮箱
     */
    @Column(length = 64)
    private String email;

    /**
     * 专业
     */
    @Column(length = 64)
    private String major;

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
     * 学历
     */
    private Short education;

    /**
     * 工作单位
     */
    @Column(length = 64)
    private String company;

    /**
     * 通讯地址
     */
    @Column(length = 256)
    private String fullAddress;

    /**
     * 邮编
     */
    @Column(length = 6)
    private String zipcode;

    /**
     * 抵达时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Instant arrivalDate;

    /**
     * 离开时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Instant departureDate;

    /**
     * 会场选择
     */
    private Long placeId;

    /**
     * 住宿选择
     */
    private Boolean boarding;

    /**
     * 宾馆选择
     */
    private Long hotelId;

    /**
     * 陪同人员
     */
    private Boolean entourage;

    /**
     * 陪同人员
     */
    private Integer accomanyNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Long meetingId) {
        this.meetingId = meetingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public Instant getBirthday() {
        return birthday;
    }

    public void setBirthday(Instant birthday) {
        this.birthday = birthday;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
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

    public Short getEducation() {
        return education;
    }

    public void setEducation(Short education) {
        this.education = education;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Instant getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Instant arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Instant getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Instant departureDate) {
        this.departureDate = departureDate;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public Boolean getBoarding() {
        return boarding;
    }

    public void setBoarding(Boolean boarding) {
        this.boarding = boarding;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Boolean getEntourage() {
        return entourage;
    }

    public void setEntourage(Boolean entourage) {
        this.entourage = entourage;
    }

    public Integer getAccomanyNumber() {
        return accomanyNumber;
    }

    public void setAccomanyNumber(Integer accomanyNumber) {
        this.accomanyNumber = accomanyNumber;
    }
}
