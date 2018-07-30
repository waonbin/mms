package com.zlsoft.domain;

import com.zlsoft.utils.domain.AbstractBaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "d_meeting_hotel")
public class MeetingHotel extends AbstractBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="mtg_hotel_id_generator")
    @TableGenerator(name = "mtg_hotel_id_generator",
            table="m_id",
            pkColumnName="pk_name",
            valueColumnName="pk_value",
            pkColumnValue="mtg_hotel_pk",
            initialValue = 10000,
            allocationSize=1
    )
    private Long id;

    /**
     * 会议id
     */
    private Long meetingId;

    /**
     * 宾馆名称
     */
    @Column(length = 64)
    private String name;

    /**
     * 宾馆地址
     */
    @Column(length = 256)
    private String address;

    /**
     * 负责人
     */
    @Column(length = 64)
    private String principle;

    /**
     * 电话
     */
    @Column(length = 16)
    private String telephone;

    /**
     * 单间押金
     */
    @Column(precision = 8, scale = 2)
    private BigDecimal dipositSingle;

    /**
     * 标间押金
     */
    @Column(precision = 8, scale = 2)
    private BigDecimal dipositStandard;

    /**
     * 报名人数限制
     */
    private Integer peopleLimit;
}
