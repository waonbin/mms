package com.zlsoft.award.model;

/**
 * 奖项配额（各单位对应奖项推荐名额）
 */
public class AwardQuotaInfo {

    private Long id;

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
