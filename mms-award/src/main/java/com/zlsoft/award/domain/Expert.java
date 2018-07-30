package com.zlsoft.award.domain;

import com.zlsoft.utils.domain.AbstractBaseEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 专家基础信息表
 */
@Entity
@Table(name = "d_expert")
public class Expert extends AbstractBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="expert_id_generator")
    @TableGenerator(name = "expert_id_generator",
            table="m_id",
            pkColumnName="pk_name",
            valueColumnName="pk_value",
            pkColumnValue="expert_pk",
            initialValue = 10000,
            allocationSize=1
    )
    private Long id;

    /**
     * 专家姓名
     */
    @Column(length = 64)
    private String name;

    /**
     * 单位
     */
    private Short referenceId;

    /**
     * 专业（字典）
     */
    private Short majorId;

    /**
     * 办公电话
     */
    @Column(length = 16)
    private String telephone;

    /**
     * 手机号码
     */
    @Column(length = 11)
    private String mobile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Short referenceId) {
        this.referenceId = referenceId;
    }

    public Short getMajorId() {
        return majorId;
    }

    public void setMajorId(Short majorId) {
        this.majorId = majorId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
