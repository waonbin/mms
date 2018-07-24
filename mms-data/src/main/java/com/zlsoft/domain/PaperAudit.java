package com.zlsoft.domain;

import com.zlsoft.utils.domain.AbstractBaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "d_paper_audit")
public class PaperAudit extends AbstractBaseEntity implements Serializable {

    @Id
    private Long paperId;

    /**
     * 论文审核（字典）
     */
    private Short paperResult;

    /**
     * 论文审核意见
     */
    @Column(columnDefinition = "TEXT")
    private String paperAudit;

    /**
     * 发言审核（字典）
     */
    private Short speechResult;

    /**
     * 发言审核意见
     */
    @Column(columnDefinition = "TEXT")
    private String speechAudit;

    public Long getPaperId() {
        return paperId;
    }

    public void setPaperId(Long paperId) {
        this.paperId = paperId;
    }

    public Short getPaperResult() {
        return paperResult;
    }

    public void setPaperResult(Short paperResult) {
        this.paperResult = paperResult;
    }

    public String getPaperAudit() {
        return paperAudit;
    }

    public void setPaperAudit(String paperAudit) {
        this.paperAudit = paperAudit;
    }

    public Short getSpeechResult() {
        return speechResult;
    }

    public void setSpeechResult(Short speechResult) {
        this.speechResult = speechResult;
    }

    public String getSpeechAudit() {
        return speechAudit;
    }

    public void setSpeechAudit(String speechAudit) {
        this.speechAudit = speechAudit;
    }
}
