package com.zlsoft.award.domain;

import com.zlsoft.utils.domain.AbstractBaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date declareDate;

    /**
     * 初审时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date firstTrialDate;

    /**
     * 复审时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date retrialDate;

    /**
     * 奖项类别
     */
    @Column(length = 64)
    private String category;

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
}
