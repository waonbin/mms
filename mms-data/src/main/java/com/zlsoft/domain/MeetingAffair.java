package com.zlsoft.domain;

import com.zlsoft.utils.domain.AbstractBaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 会务信息
 */
@Entity
@Table(name = "d_meeting_affair")
public class MeetingAffair extends AbstractBaseEntity implements Serializable {

    /**
     * 会议id
     */
    @Id
    private Long meetingId;

    /**
     * 会议日程
     */
    @Column(columnDefinition = "TEXT")
    private String schedule;

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
     * 会议论文
     */
    @Column(columnDefinition = "TEXT")
    private String paperInfo;

    /**
     * 会议概述
     */
    @Column(columnDefinition = "TEXT")
    private String meetingInfo;

    /**
     * 演讲嘉宾
     */
    @Column(columnDefinition = "TEXT")
    private String speakerInfo;

    /**
     * 交通信息
     */
    @Column(columnDefinition = "TEXT")
    private String hotelInfo;

    /**
     * 交通信息
     */
    @Column(columnDefinition = "TEXT")
    private String trafficInfo;

    /**
     * 联系我们
     */
    @Column(columnDefinition = "TEXT")
    private String contactUs;

    /**
     * 赞助单位
     */
    @Column(columnDefinition = "TEXT")
    private String supportingAgency;

    public Long getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Long meetingId) {
        this.meetingId = meetingId;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
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

    public String getPaperInfo() {
        return paperInfo;
    }

    public void setPaperInfo(String paperInfo) {
        this.paperInfo = paperInfo;
    }

    public String getMeetingInfo() {
        return meetingInfo;
    }

    public void setMeetingInfo(String meetingInfo) {
        this.meetingInfo = meetingInfo;
    }

    public String getSpeakerInfo() {
        return speakerInfo;
    }

    public void setSpeakerInfo(String speakerInfo) {
        this.speakerInfo = speakerInfo;
    }

    public String getHotelInfo() {
        return hotelInfo;
    }

    public void setHotelInfo(String hotelInfo) {
        this.hotelInfo = hotelInfo;
    }

    public String getTrafficInfo() {
        return trafficInfo;
    }

    public void setTrafficInfo(String trafficInfo) {
        this.trafficInfo = trafficInfo;
    }

    public String getContactUs() {
        return contactUs;
    }

    public void setContactUs(String contactUs) {
        this.contactUs = contactUs;
    }

    public String getSupportingAgency() {
        return supportingAgency;
    }

    public void setSupportingAgency(String supportingAgency) {
        this.supportingAgency = supportingAgency;
    }
}
