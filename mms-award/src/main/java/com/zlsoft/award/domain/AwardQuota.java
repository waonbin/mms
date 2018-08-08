package com.zlsoft.award.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zlsoft.utils.domain.AbstractBaseEntity;

/**
 * 奖项配额（各单位对应奖项推荐名额）
 */
@Entity
@Table(name = "d_award_quota")
public class AwardQuota extends AbstractBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="award_quota_id_generator")
    @TableGenerator(name = "award_quota_id_generator",
            table="m_id",
            pkColumnName="pk_name",
            valueColumnName="pk_value",
            pkColumnValue="award_quota_pk",
            initialValue = 10000,
            allocationSize=1
    )
    private Long id;

//    /**
//     * 奖项id
//     */
//    private Long awardId;

    /**
     * 推荐单位id
     */    
    @OneToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name="referenceId",referencedColumnName = "id")
    private Reference reference;

    /**
     * 推荐名额
     */
    private Integer quota;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="awardId")
    private Award award;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Long getAwardId() {
//        return awardId;
//    }
//
//    public void setAwardId(Long awardId) {
//        this.awardId = awardId;
//    }

	public Reference getReference() {
		return reference;
	}

	public void setReference(Reference reference) {
		this.reference = reference;
	}
	
    public Integer getQuota() {
        return quota;
    }

	public void setQuota(Integer quota) {
        this.quota = quota;
    }

	public Award getAward() {
		return award;
	}

	public void setAward(Award award) {
		this.award = award;
	}
}
