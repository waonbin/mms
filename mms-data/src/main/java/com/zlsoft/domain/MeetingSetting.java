package com.zlsoft.domain;

import com.zlsoft.utils.domain.AbstractBaseEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 会议菜单设置
 */
@Entity
@Table(name = "d_meeting_setting")
public class MeetingSetting extends AbstractBaseEntity implements Serializable {

    /**
     * 会议id
     */
    @Id
    private Long id;

    /**
     * 会议展览
     */
    private Boolean exhibition;

    /**
     * 会议报告
     */
    private Boolean report;

    /**
     * 会议论文
     */
    private Boolean paper;

    /**
     * 会议概述
     */
    private Boolean summary;

    /**
     * 文件下载
     */
    private Boolean download;

    /**
     * 会议日程
     */
    private Boolean schedule;

    /**
     * 演讲嘉宾
     */
    private Boolean speaker;

    /**
     * 酒店预订
     */
    private Boolean hotel;

    /**
     * 交通信息
     */
    private Boolean traffic;

    /**
     * 联系我们
     */
    private Boolean contact;

    /**
     * 赞助支持
     */
    private Boolean support;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getExhibition() {
        return exhibition;
    }

    public void setExhibition(Boolean exhibition) {
        this.exhibition = exhibition;
    }

    public Boolean getReport() {
        return report;
    }

    public void setReport(Boolean report) {
        this.report = report;
    }

    public Boolean getPaper() {
        return paper;
    }

    public void setPaper(Boolean paper) {
        this.paper = paper;
    }

    public Boolean getSummary() {
        return summary;
    }

    public void setSummary(Boolean summary) {
        this.summary = summary;
    }

    public Boolean getDownload() {
        return download;
    }

    public void setDownload(Boolean download) {
        this.download = download;
    }

    public Boolean getSchedule() {
        return schedule;
    }

    public void setSchedule(Boolean schedule) {
        this.schedule = schedule;
    }

    public Boolean getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Boolean speaker) {
        this.speaker = speaker;
    }

    public Boolean getHotel() {
        return hotel;
    }

    public void setHotel(Boolean hotel) {
        this.hotel = hotel;
    }

    public Boolean getTraffic() {
        return traffic;
    }

    public void setTraffic(Boolean traffic) {
        this.traffic = traffic;
    }

    public Boolean getContact() {
        return contact;
    }

    public void setContact(Boolean contact) {
        this.contact = contact;
    }

    public Boolean getSupport() {
        return support;
    }

    public void setSupport(Boolean support) {
        this.support = support;
    }
}
