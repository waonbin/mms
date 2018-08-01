package com.zlsoft.domain;

import com.zlsoft.utils.domain.AbstractBaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "d_meeting")
public class Meeting extends AbstractBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="meeting_id_generator")
    @TableGenerator(name = "meeting_id_generator",
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
     * 举办开始时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startDate;

    /**
     * 举办结束时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endDate;

    /**
     * 报名人数限制
     */
    private Short peopleLimit;

    /**
     * 主办单位
     */
    @Column(length = 64)
    private String sponsor;

    /**
     * 承办单位
     */
    @Column(length = 64)
    private String organizer;

    /**
     * 会议地址
     */
    @Column(length = 256)
    private String address;

    /**
     * 经度（地址坐标）
     */
    private Double longitude;

    /**
     * 维度（地址坐标）
     */
    private Double latitude;

    /**
     * 会议费用类型（字典）
     */
    private Short duesType;

    /**
     * 是否在系统中收费
     */
    private Boolean chargeInSystem;

    /**
     * 报到日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Instant checkinDate;

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Short getPeopleLimit() {
        return peopleLimit;
    }

    public void setPeopleLimit(Short peopleLimit) {
        this.peopleLimit = peopleLimit;
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

    public Short getDuesType() {
        return duesType;
    }

    public void setDuesType(Short duesType) {
        this.duesType = duesType;
    }

    public Boolean getChargeInSystem() {
        return chargeInSystem;
    }

    public void setChargeInSystem(Boolean chargeInSystem) {
        this.chargeInSystem = chargeInSystem;
    }

    public Instant getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(Instant checkinDate) {
        this.checkinDate = checkinDate;
    }
}