package com.zlsoft.domain;

import javax.persistence.*;

@Entity
@Table(name = "d_meeting_report")
public class MeetingPaper {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="paper_id_generator")
    @TableGenerator(name = "paper_id_generator",
            table="m_id",
            pkColumnName="pk_name",
            valueColumnName="pk_value",
            pkColumnValue="paper_pk",
            initialValue = 10000,
            allocationSize=1
    )
    private Long id;

    /**
     * 报名登记Id
     */
    private Long enrollmentId;

    /**
     * 是否发言
     */
    private Short isSpeak;

    /**
     * 论文标题
     */
    @Column(length = 256)
    private String paper;

    /**
     * 字数（千字）
     */
    private Double wordCount;

    /**
     * 关键词
     */
    @Column(length = 256)
    private String keywords;

    /**
     * 摘要
     */
    @Column(length = 1024)
    private String summary;

    /**
     * 论文Id
     */
    private Long fileId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(Long enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Short getIsSpeak() {
        return isSpeak;
    }

    public void setIsSpeak(Short isSpeak) {
        this.isSpeak = isSpeak;
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }

    public Double getWordCount() {
        return wordCount;
    }

    public void setWordCount(Double wordCount) {
        this.wordCount = wordCount;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }
}
