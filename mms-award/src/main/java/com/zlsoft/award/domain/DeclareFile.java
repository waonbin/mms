package com.zlsoft.award.domain;

import javax.persistence.*;

/**
 * 奖项申报相关材料表
 */
@Entity
@Table(name = "d_declare_file")
public class DeclareFile {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="declare_file_id_generator")
    @TableGenerator(name = "declare_file_id_generator",
            table="m_id",
            pkColumnName="pk_name",
            valueColumnName="pk_value",
            pkColumnValue="declare_file_pk",
            initialValue = 10000,
            allocationSize=1
    )
    private Long id;

    /**
     * 申报id
     */
    private Long declareId;

    /**
     * 文件类型（字典）
     */
    private Short fileType;

    /**
     * 文件信息id（关联FileMetadata）
     */
    private Long fileId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeclareId() {
        return declareId;
    }

    public void setDeclareId(Long declareId) {
        this.declareId = declareId;
    }

    public Short getFileType() {
        return fileType;
    }

    public void setFileType(Short fileType) {
        this.fileType = fileType;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }
}
