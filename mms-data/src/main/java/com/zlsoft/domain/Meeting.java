package com.zlsoft.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "d_meeting")
public class Meeting implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="id_generator")
    @TableGenerator(name = "id_generator",
            table="m_id",
            pkColumnName="pk_name",
            valueColumnName="pk_value",
            pkColumnValue="meeting_pk",
            initialValue = 10000,
            allocationSize=1
    )
    private Long id;

    /**
     * 会议名称
     */
    @Column(length = 64)
    private String name;

    /**
     * 会议内容
     */
    @Column(columnDefinition = "TEXT")
    private String content;

    /**
     * 会议简介
     */
    @Column(columnDefinition = "TEXT")
    private String description;

    /**
     * 会议类型（字典）
     */
    private Short meetingType;

    /**
     * 报名人数限制
     */
    private Short enrollmentLimit;

    /**
     * 会员价
     */
    private Double vipPrice;

    /**
     * 非会员价
     */
    private Double price;

    /**
     * 报名开始时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date enrollStartDate;

    /**
     * 报名结束时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date enrollEndDate;

    /**
     * 报到日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date checkinDate;

    /**
     * 会议地址
     */
    @Column(length = 256)
    private String address;

    /**
     * 精度（地址坐标）
     */
    private Double longitude;

    /**
     * 维度（地址坐标）
     */
    private Double latitude;

    /**
     * 会议展览
     */
    @Column(columnDefinition = "TEXT")
    private String exhibitionInfo;

    /**
     * 会议报告
     */
    @Column(columnDefinition = "TEXT")
    private String reportInfo;

    /**
     * 酒店信息
     */
    @Column(columnDefinition = "TEXT")
    private String hotalInfo;

    /**
     * 交通信息
     */
    @Column(columnDefinition = "TEXT")
    private String trafficInfo;

    /**
     * 赞助单位
     */
    @Column(columnDefinition = "TEXT")
    private String sponsor;

    /**
     * 承办单位
     */
    @Column(columnDefinition = "TEXT")
    private String organizer;

    /**
     * 联系我们
     */
    @Column(columnDefinition = "TEXT")
    private String contactUs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Short getMeetingType() {
        return meetingType;
    }

    public void setMeetingType(Short meetingType) {
        this.meetingType = meetingType;
    }

    public Short getEnrollmentLimit() {
        return enrollmentLimit;
    }

    public void setEnrollmentLimit(Short enrollmentLimit) {
        this.enrollmentLimit = enrollmentLimit;
    }

    public Double getVipPrice() {
        return vipPrice;
    }

    public void setVipPrice(Double vipPrice) {
        this.vipPrice = vipPrice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getEnrollStartDate() {
        return enrollStartDate;
    }

    public void setEnrollStartDate(Date enrollStartDate) {
        this.enrollStartDate = enrollStartDate;
    }

    public Date getEnrollEndDate() {
        return enrollEndDate;
    }

    public void setEnrollEndDate(Date enrollEndDate) {
        this.enrollEndDate = enrollEndDate;
    }

    public Date getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Date checkinDate) {
        this.checkinDate = checkinDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getExhibitionInfo() {
        return exhibitionInfo;
    }

    public void setExhibitionInfo(String exhibitionInfo) {
        this.exhibitionInfo = exhibitionInfo;
    }

    public String getReportInfo() {
        return reportInfo;
    }

    public void setReportInfo(String reportInfo) {
        this.reportInfo = reportInfo;
    }

    public String getHotalInfo() {
        return hotalInfo;
    }

    public void setHotalInfo(String hotalInfo) {
        this.hotalInfo = hotalInfo;
    }

    public String getTrafficInfo() {
        return trafficInfo;
    }

    public void setTrafficInfo(String trafficInfo) {
        this.trafficInfo = trafficInfo;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getContactUs() {
        return contactUs;
    }

    public void setContactUs(String contactUs) {
        this.contactUs = contactUs;
    }
}