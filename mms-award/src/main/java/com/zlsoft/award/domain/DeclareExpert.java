package com.zlsoft.award.domain;

import com.zlsoft.utils.domain.AbstractBaseEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 申报材料审核专家分配表
 */
@Entity
@Table(name = "d_declare_expert")
public class DeclareExpert extends AbstractBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="declare_id_generator")
    @TableGenerator(name = "declare_id_generator",
            table="m_id",
            pkColumnName="pk_name",
            valueColumnName="pk_value",
            pkColumnValue="declare_pk",
            initialValue = 10000,
            allocationSize=1
    )
    private Long id;

    /**
     * 申报id
     */
    private Long declareId;

    /**
     * 专家id
     */
    private Long expertId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeclareId() {
        return declareId;
    }

    public void setDeclareId(Long declareId) {
        this.declareId = declareId;
    }

    public Long getExpertId() {
        return expertId;
    }

    public void setExpertId(Long expertId) {
        this.expertId = expertId;
    }
}
