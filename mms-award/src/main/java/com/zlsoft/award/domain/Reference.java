package com.zlsoft.award.domain;

import com.zlsoft.utils.domain.AbstractBaseEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 推荐单位基本信息
 */
@Entity
@Table(name = "d_reference")
public class Reference extends AbstractBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="reference_id_generator")
    @TableGenerator(name = "reference_id_generator",
            table="m_id",
            pkColumnName="pk_name",
            valueColumnName="pk_value",
            pkColumnValue="reference_pk",
            initialValue = 10000,
            allocationSize=1
    )
    private Long id;

    /**
     * 单位名称
     */
    @Column(length = 64)
    private String name;

    /**
     * 单位地点
     */
    @Column(length = 256)
    private String address;

    /**
     * 单位领导
     */
    @Column(length = 64)
    private String leader;

    /**
     * 奖项负责人
     */
    @Column(length = 64)
    private String principle;

    /**
     * 联系方式
     */
    @Column(length = 16)
    private String telephone;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getPrinciple() {
        return principle;
    }

    public void setPrinciple(String principle) {
        this.principle = principle;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
