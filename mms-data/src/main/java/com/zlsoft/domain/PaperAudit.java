package com.zlsoft.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "d_paper_audit")
public class PaperAudit implements Serializable {

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
     * 论文审核（字典）
     */
    private Short paperResult;

    /**
     * 论文审核意见
     */
    @Column(columnDefinition = "TEXT")
    private String paperAudit;

    /**
     * 发言审核（字典）
     */
    private Short speechResult;

    /**
     * 发言审核意见
     */
    @Column(columnDefinition = "TEXT")
    private String speechAudit;
}
