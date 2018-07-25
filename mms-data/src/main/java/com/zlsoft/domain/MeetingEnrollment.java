package com.zlsoft.domain;

import com.zlsoft.utils.domain.AbstractBaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "d_meeting_enrollment")
public class MeetingEnrollment extends AbstractBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="enrollment_id_generator")
    @TableGenerator(name = "enrollment_id_generator",
            table="m_id",
            pkColumnName="pk_name",
            valueColumnName="pk_value",
            pkColumnValue="enrollment_pk",
            initialValue = 10000,
            allocationSize=1
    )
    private Long id;

    /**
     * 会员Id
     */
    private Long memberId;

    /**
     * 工作单位
     */
    @Column(length = 64)
    private String company;

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
     * 年龄
     */
    private Short age;

    /**
     * 职称
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
     * 酒店信息
     */
    private Long hotelId;

    /**
     * 入住日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date checkInData;

    /**
     * 离店日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date checkOutData;

    /**
     * 论文/摘要题目
     */
    @Column(length = 256)
    private String paper;

    /**
     * 口头报告（字典）
     */
    private Short oralReport;

    /**
     * 所属分会场
     */
    private Long parallelSessionId;

    /**
     * 所属分会场
     */
    @Column(columnDefinition = "TEXT")
    private String comment;
}
