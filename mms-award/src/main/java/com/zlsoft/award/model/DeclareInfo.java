package com.zlsoft.award.model;

import java.util.Date;

/**
 * 奖项申报信息
 */
public class DeclareInfo {

    private Long id;
    
    /**
     * 申报状态
     */
    private Integer status;


	private Long awardId;

    /**
     * 奖项名称
     */
    private String name;

    /**
     * 奖项内容
     */
    private String content;

    /**
     * 申报时间
     */
    private Date declareDate;

    /**
     * 初审时间
     */
    private Date firstTrialDate;

    /**
     * 复审时间
     */
    private Date retrialDate;

    /**
     * 奖项类别
     */
    private String category;
    
    private String major;
    
    private String referenceId;
    private String referenceName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getAwardId() {
		return awardId;
	}

	public void setAwardId(Long awardId) {
		this.awardId = awardId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDeclareDate() {
		return declareDate;
	}

	public void setDeclareDate(Date declareDate) {
		this.declareDate = declareDate;
	}

	public Date getFirstTrialDate() {
		return firstTrialDate;
	}

	public void setFirstTrialDate(Date firstTrialDate) {
		this.firstTrialDate = firstTrialDate;
	}

	public Date getRetrialDate() {
		return retrialDate;
	}

	public void setRetrialDate(Date retrialDate) {
		this.retrialDate = retrialDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public String getReferenceName() {
		return referenceName;
	}

	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}
	
}
