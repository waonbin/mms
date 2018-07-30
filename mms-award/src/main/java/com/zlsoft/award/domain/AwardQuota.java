package com.zlsoft.award.domain;

import com.zlsoft.utils.domain.AbstractBaseEntity;

import javax.persistence.*;
import java.io.Serializable;

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

    /**
     * 奖项id
     */
    private Long awardId;

    /**
     * 推荐单位id
     */
    private Long referenceId;

    /**
     * 推荐名额
     */
    private Integer quota;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAwardId() {
        return awardId;
    }

    public void setAwardId(Long awardId) {
        this.awardId = awardId;
    }

    public Long getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
    }

    public Integer getQuota() {
        return quota;
    }

    public void setQuota(Integer quota) {
        this.quota = quota;
    }
}
