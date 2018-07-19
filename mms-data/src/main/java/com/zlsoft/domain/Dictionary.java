package com.zlsoft.domain;

import javax.persistence.*;

@Entity
@Table(name = "m_dictionary")
public class Dictionary {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="dictionary_id_generator")
    @TableGenerator(name = "dictionary_id_generator",
            table="m_id",
            pkColumnName="pk_name",
            valueColumnName="pk_value",
            pkColumnValue="dictionary_pk",
            initialValue = 10000,
            allocationSize=1
    )
    private Long id;

    /**
     * 编码
     */
    @Column(length = 64)
    private String code;

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
     * 是否是内置字典
     */
    private Short buildin;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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

    public Short getBuildin() {
        return buildin;
    }

    public void setBuildin(Short buildin) {
        this.buildin = buildin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
