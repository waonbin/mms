package com.zlsoft.domain;

import javax.persistence.*;

@Entity
@Table(name = "m_dictionary_item")
public class DictionaryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="dictionary_item_id_generator")
    @TableGenerator(name = "dictionary_item_id_generator",
            table="m_id",
            pkColumnName="pk_name",
            valueColumnName="pk_value",
            pkColumnValue="dictionary_item_pk",
            initialValue = 10000,
            allocationSize=1
    )
    private Long id;

    /**
     * 字典ID
     */
    private Long dictionaryId;

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
     * 字典项的值
     */
    private Short value;

    /**
     * 序号
     */
    private Integer seq;

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

    public Long getDictionaryId() {
        return dictionaryId;
    }

    public void setDictionaryId(Long dictionaryId) {
        this.dictionaryId = dictionaryId;
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

    public Short getValue() {
        return value;
    }

    public void setValue(Short value) {
        this.value = value;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
