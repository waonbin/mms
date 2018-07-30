package com.zlsoft.domain;

import com.zlsoft.utils.domain.AbstractBaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_register_setting_item")
public class RegisterSettingItem extends AbstractBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="t_register_setting_item_id_generator")
    @TableGenerator(name = "t_register_setting_item_id_generator",
            table="m_id",
            pkColumnName="pk_name",
            valueColumnName="pk_value",
            pkColumnValue="t_register_setting_item_pk",
            initialValue = 10000,
            allocationSize=1
    )
    private Long id;

    /**
     * 会议id
     */
    private Long templateId;

    /**
     * 字段名称
     */
    @Column(length = 64)
    private String field;

    /**
     * 字段标题
     */
    @Column(length = 64)
    private String fieldCaption;

    /**
     * 字段类型（字典）
     */
    private Short fieldType;

    /**
     * 字段长度
     */
    private Integer fieldLength;

    /**
     * 编辑器类型（字典）
     */
    private Short editorType;

    /**
     * 显示顺序
     */
    private Integer seq;

    /**
     * 是否显示
     */
    private Boolean display;

    /**
     * 是否必填
     */
    private Boolean nullable;

    /**
     * 校验规则（英语）
     */
    private Short checkRule;

    /**
     * 填写分组（英语）
     */
    private Short groupType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getFieldCaption() {
        return fieldCaption;
    }

    public void setFieldCaption(String fieldCaption) {
        this.fieldCaption = fieldCaption;
    }

    public Short getFieldType() {
        return fieldType;
    }

    public void setFieldType(Short fieldType) {
        this.fieldType = fieldType;
    }

    public Integer getFieldLength() {
        return fieldLength;
    }

    public void setFieldLength(Integer fieldLength) {
        this.fieldLength = fieldLength;
    }

    public Short getEditorType() {
        return editorType;
    }

    public void setEditorType(Short editorType) {
        this.editorType = editorType;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Boolean getDisplay() {
        return display;
    }

    public void setDisplay(Boolean display) {
        this.display = display;
    }

    public Boolean getNullable() {
        return nullable;
    }

    public void setNullable(Boolean nullable) {
        this.nullable = nullable;
    }

    public Short getCheckRule() {
        return checkRule;
    }

    public void setCheckRule(Short checkRule) {
        this.checkRule = checkRule;
    }

    public Short getGroupType() {
        return groupType;
    }

    public void setGroupType(Short groupType) {
        this.groupType = groupType;
    }
}
