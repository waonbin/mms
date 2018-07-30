package com.zlsoft.domain;

import javax.persistence.*;

/**
 * 会议报名费用
 */
@Entity
@Table(name = "d_meeting_place")
public class MeetingPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="mtg_place_id_generator")
    @TableGenerator(name = "mtg_place_id_generator",
            table="m_id",
            pkColumnName="pk_name",
            valueColumnName="pk_value",
            pkColumnValue="mtg_place_pk",
            initialValue = 10000,
            allocationSize=1
    )
    private Long id;

    /**
     * 会议id
     */
    private Long meetingId;

    /**
     * 会场名称
     */
    @Column(length = 64)
    private String name;

    /**
     * 会场主题
     */
    @Column(length = 64)
    private String subject;

    /**
     * 会场地址
     */
    @Column(length = 256)
    private String address;

    /**
     * 承办单位
     */
    @Column(length = 64)
    private String organizer;

    /**
     * 报名人数限制
     */
    private Integer peopleLimit;
}
