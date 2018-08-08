package com.zlsoft.award.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zlsoft.utils.domain.AbstractBaseEntity;

/**
 * 奖项基本信息
 */
@Entity
@Table(name = "d_award")
public class Award extends AbstractBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="award_id_generator")
    @TableGenerator(name = "award_id_generator",
            table="m_id",
            pkColumnName="pk_name",
            valueColumnName="pk_value",
            pkColumnValue="award_pk",
            initialValue = 10000,
            allocationSize=1
    )
    private Long id;

    /**
     * 奖项名称
     */
    @Column(length = 64)
    private String name;

    /**
     * 奖项内容
     */
    @Column(columnDefinition = "TEXT")
    private String content;

    /**
     * 申报时间
     */
//    @JsonFormat(pattern = “yyyy-MM-dd HH:mm:ss”, locale = “zh”, timezone=”GMT+8”)
//    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone="GMT+8")
    private Date declareDate;

    /**
     * 初审时间
     */
//    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone="GMT+8")
    private Date firstTrialDate;

    /**
     * 复审时间
     */
//    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone="GMT+8")
    private Date retrialDate;

    /**
     * 奖项类别
     */
    @Column(length = 64)
    private String category;
    
    @Column(length=50)
    private String major;
    
    /**
     * 投递数量
     */
    @Transient
    private Integer count;
    
    /**
     * 评奖进度
     */
    @Transient
    private String processStatus;
    
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name="awardId")
    private List<AwardQuota> awardQuotas;
    
    @OneToMany(cascade = {CascadeType.REFRESH,CascadeType.REMOVE})
    @JoinColumn(name="awardId")
    private List<Declare> declares;

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

	public List<AwardQuota> getAwardQuotas() {
		if(awardQuotas == null){
			return new ArrayList<AwardQuota>();
		}
		return awardQuotas;
	}

	public void setAwardQuotas(List<AwardQuota> awardQuotas) {
		this.awardQuotas = awardQuotas;
	}

	public List<Declare> getDeclares() {
		if(declares == null){
			return new ArrayList<Declare>();
		}
		return declares;
	}

	public void setDeclares(List<Declare> declares) {
		this.declares = declares;
	}   
    
}
