package com.zlsoft.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "d_meeting_report")
public class MeetingPaper implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="id_generator")
    @TableGenerator(name = "id_generator",
            table="m_id",
            pkColumnName="pk_name",
            valueColumnName="pk_value",
            pkColumnValue="enrollment_pk",
            initialValue = 10000,
            allocationSize=1
    )
    private Long id;

    /**
     * 报名登记Id
     */
    private Long enrollmentId;

    /**
     * 是否发言
     */
    private Short isSpeak;

    /**
     * 论文标题
     */
    @Column(length = 256)
    private String paper;

    /**
     * 字数（千字）
     */
    private Double wordCount;

    /**
     * 关键词
     */
    @Column(length = 256)
    private String keywords;

    /**
     * 摘要
     */
    @Column(length = 1024)
    private String summary;

    /**
     * 论文Id
     */
    private Long fileId;
}
