package com.zlsoft.award.domain;

import javax.persistence.*;

/**
 * 申报审核流程历史信息
 */
@Entity
@Table(name = "d_declare_history")
public class DeclareHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="declare_history_id_generator")
    @TableGenerator(name = "declare_history_id_generator",
            table="m_id",
            pkColumnName="pk_name",
            valueColumnName="pk_value",
            pkColumnValue="declare_history_pk",
            initialValue = 10000,
            allocationSize=1
    )
    private Long id;

    /**
     * 申报审核动作（字典）
     */
    private Short actionType;

    /**
     * 申报审核结果：通过 or 不通过
     */
    private Boolean actionResult;

    /**
     * 申报审核结果状态码
     */
    private Short status;

    /**
     * 审核不通过的原因
     */
    @Column(length = 512)
    private String reason;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getActionType() {
        return actionType;
    }

    public void setActionType(Short actionType) {
        this.actionType = actionType;
    }

    public Boolean getActionResult() {
        return actionResult;
    }

    public void setActionResult(Boolean actionResult) {
        this.actionResult = actionResult;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
