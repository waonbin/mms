package com.zlsoft.domain;

import com.zlsoft.utils.domain.AbstractBaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 会议报名费用
 */
@Entity
@Table(name = "d_meeting_dues")
public class MeetingDues extends AbstractBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="mtg_dues_id_generator")
    @TableGenerator(name = "mtg_dues_id_generator",
            table="m_id",
            pkColumnName="pk_name",
            valueColumnName="pk_value",
            pkColumnValue="mtg_dues_pk",
            initialValue = 10000,
            allocationSize=1
    )
    private Long id;

    /**
     * 会议id
     */
    private Long meetingId;

    /**
     * 会员类型
     */
    private Short memberType;

    /**
     * 开始时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date startDate;

    /**
     * 结束时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date endDate;

    /**
     * 会议费用
     */
    @Column(precision = 8, scale = 2)
    private BigDecimal dues;

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

    public Short getMemberType() {
        return memberType;
    }

    public void setMemberType(Short memberType) {
        this.memberType = memberType;
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

    public BigDecimal getDues() {
        return dues;
    }

    public void setDues(BigDecimal dues) {
        this.dues = dues;
    }
}
