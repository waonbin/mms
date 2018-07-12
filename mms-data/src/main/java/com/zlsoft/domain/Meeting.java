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

}