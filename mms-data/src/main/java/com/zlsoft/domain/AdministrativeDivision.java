package com.zlsoft.domain;

import javax.persistence.*;

@Entity
@Table(name = "m_administrative_division")
public class AdministrativeDivision {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="division_id_generator")
    @TableGenerator(name = "division_id_generator",
            table="m_id",
            pkColumnName="pk_name",
            valueColumnName="pk_value",
            pkColumnValue="division_pk",
            initialValue = 10000,
            allocationSize=1
    )
    private Long id;

    /**
     * 父ID（树形结构）
     */
    private Long parentId;

    /**
     * 编码
     */
    private Integer code;

    /**
     * 名称
     */
    @Column(length = 64)
    private String name;

    /**
     * 序号
     */
    private Integer seq;

    /**
     * 层级
     */
    private Integer level;

    /**
     * 描述
     */
    @Column(length = 512)
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
