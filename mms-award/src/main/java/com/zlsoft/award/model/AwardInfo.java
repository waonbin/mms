package com.zlsoft.award.model;

import java.util.Date;
import java.util.List;

public class AwardInfo {
	private Long id;

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
    /**
     * 奖项专业
     */
    private String major;
    
    /**
     * 投递数量
     */
    private Integer count;
    
    /**
     * 评奖进度
     */
    private String processStatus;
    
    private List<AwardQuotaInfo> awardQuotaInfos;
    
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

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	public List<AwardQuotaInfo> getAwardQuotaInfos() {
		return awardQuotaInfos;
	}

	public void setAwardQuotaInfos(List<AwardQuotaInfo> awardQuotaInfos) {
		this.awardQuotaInfos = awardQuotaInfos;
	}
}
