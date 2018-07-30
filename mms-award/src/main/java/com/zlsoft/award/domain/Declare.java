package com.zlsoft.award.domain;

import com.zlsoft.utils.domain.AbstractBaseEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 奖项申报信息
 */
@Entity
@Table(name = "d_declare")
public class Declare extends AbstractBaseEntity implements Serializable {

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
     * 奖项id
     */
    private Long awardId;

    /**
     * 申报状态
     */
    private Short status;
}
