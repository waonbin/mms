package com.zlsoft.domain;

import com.zlsoft.utils.domain.AbstractBaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "d_meeting_register_ext")
public class MeetingRegisterExt extends AbstractBaseEntity implements Serializable {

    @Id
    private Long id;

    /**
     * 字符串扩展字段1
     */
    @Column(length = 256)
    private String string0;

    /**
     * 字符串扩展字段2
     */
    @Column(length = 256)
    private String string1;

    /**
     * 字符串扩展字段3
     */
    @Column(length = 256)
    private String string2;

    /**
     * 字符串扩展字段4
     */
    @Column(length = 256)
    private String string3;

    /**
     * 字符串扩展字段5
     */
    @Column(length = 256)
    private String string4;

    /**
     * 字符串扩展字段6
     */
    @Column(length = 256)
    private String string5;

    /**
     * 字符串扩展字段7
     */
    @Column(length = 256)
    private String string6;

    /**
     * 字符串扩展字段8
     */
    @Column(length = 256)
    private String string7;

    /**
     * 字符串扩展字段9
     */
    @Column(length = 256)
    private String string8;

    /**
     * 字符串扩展字段10
     */
    @Column(length = 256)
    private String string9;

    /**
     * 文本扩展字段1
     */
    @Column(columnDefinition = "TEXT")
    private String text0;

    /**
     * 文本扩展字段2
     */
    @Column(columnDefinition = "TEXT")
    private String text1;

    /**
     * 文本扩展字段3
     */
    @Column(columnDefinition = "TEXT")
    private String text2;

    /**
     * 文本扩展字段4
     */
    @Column(columnDefinition = "TEXT")
    private String text3;

    /**
     * 文本扩展字段5
     */
    @Column(columnDefinition = "TEXT")
    private String text4;

    /**
     * 字典扩展字段1
     */
    private Short dict0;

    /**
     * 字典扩展字段2
     */
    private Short dict1;

    /**
     * 字典扩展字段3
     */
    private Short dict2;

    /**
     * 字典扩展字段4
     */
    private Short dict3;

    /**
     * 字典扩展字段5
     */
    private Short dict4;

    /**
     * 整型扩展字段1
     */
    private Integer integer0;

    /**
     * 整型扩展字段2
     */
    private Integer integer1;

    /**
     * 整型扩展字段3
     */
    private Integer integer2;

    /**
     * 整型扩展字段4
     */
    private Integer integer3;

    /**
     * 整型扩展字段5
     */
    private Integer integer4;

    /**
     * 浮点数扩展字段1
     */
    private Double double0;

    /**
     * 浮点数扩展字段2
     */
    private Double double1;

    /**
     * 浮点数扩展字段3
     */
    private Double double2;

    /**
     * 浮点数扩展字段4
     */
    private Double double3;

    /**
     * 浮点数扩展字段5
     */
    private Double double4;

    /**
     * 日期扩展字段1
     */
    private Instant date0;

    /**
     * 日期扩展字段2
     */
    private Instant date1;

    /**
     * 日期扩展字段3
     */
    private Instant date2;

    /**
     * 日期扩展字段4
     */
    private Instant date3;

    /**
     * 日期扩展字段5
     */
    private Instant date4;

    /**
     * 布尔型扩展字段1
     */
    private Boolean bool0;

    /**
     * 布尔型扩展字段2
     */
    private Boolean bool1;

    /**
     * 布尔型扩展字段3
     */
    private Boolean bool2;

    /**
     * 布尔型扩展字段4
     */
    private Boolean bool3;

    /**
     * 布尔型扩展字段5
     */
    private Boolean bool4;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getString0() {
        return string0;
    }

    public void setString0(String string0) {
        this.string0 = string0;
    }

    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    public String getString2() {
        return string2;
    }

    public void setString2(String string2) {
        this.string2 = string2;
    }

    public String getString3() {
        return string3;
    }

    public void setString3(String string3) {
        this.string3 = string3;
    }

    public String getString4() {
        return string4;
    }

    public void setString4(String string4) {
        this.string4 = string4;
    }

    public String getString5() {
        return string5;
    }

    public void setString5(String string5) {
        this.string5 = string5;
    }

    public String getString6() {
        return string6;
    }

    public void setString6(String string6) {
        this.string6 = string6;
    }

    public String getString7() {
        return string7;
    }

    public void setString7(String string7) {
        this.string7 = string7;
    }

    public String getString8() {
        return string8;
    }

    public void setString8(String string8) {
        this.string8 = string8;
    }

    public String getString9() {
        return string9;
    }

    public void setString9(String string9) {
        this.string9 = string9;
    }

    public String getText0() {
        return text0;
    }

    public void setText0(String text0) {
        this.text0 = text0;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public String getText4() {
        return text4;
    }

    public void setText4(String text4) {
        this.text4 = text4;
    }

    public Short getDict0() {
        return dict0;
    }

    public void setDict0(Short dict0) {
        this.dict0 = dict0;
    }

    public Short getDict1() {
        return dict1;
    }

    public void setDict1(Short dict1) {
        this.dict1 = dict1;
    }

    public Short getDict2() {
        return dict2;
    }

    public void setDict2(Short dict2) {
        this.dict2 = dict2;
    }

    public Short getDict3() {
        return dict3;
    }

    public void setDict3(Short dict3) {
        this.dict3 = dict3;
    }

    public Short getDict4() {
        return dict4;
    }

    public void setDict4(Short dict4) {
        this.dict4 = dict4;
    }

    public Integer getInteger0() {
        return integer0;
    }

    public void setInteger0(Integer integer0) {
        this.integer0 = integer0;
    }

    public Integer getInteger1() {
        return integer1;
    }

    public void setInteger1(Integer integer1) {
        this.integer1 = integer1;
    }

    public Integer getInteger2() {
        return integer2;
    }

    public void setInteger2(Integer integer2) {
        this.integer2 = integer2;
    }

    public Integer getInteger3() {
        return integer3;
    }

    public void setInteger3(Integer integer3) {
        this.integer3 = integer3;
    }

    public Integer getInteger4() {
        return integer4;
    }

    public void setInteger4(Integer integer4) {
        this.integer4 = integer4;
    }

    public Double getDouble0() {
        return double0;
    }

    public void setDouble0(Double double0) {
        this.double0 = double0;
    }

    public Double getDouble1() {
        return double1;
    }

    public void setDouble1(Double double1) {
        this.double1 = double1;
    }

    public Double getDouble2() {
        return double2;
    }

    public void setDouble2(Double double2) {
        this.double2 = double2;
    }

    public Double getDouble3() {
        return double3;
    }

    public void setDouble3(Double double3) {
        this.double3 = double3;
    }

    public Double getDouble4() {
        return double4;
    }

    public void setDouble4(Double double4) {
        this.double4 = double4;
    }

    public Instant getDate0() {
        return date0;
    }

    public void setDate0(Instant date0) {
        this.date0 = date0;
    }

    public Instant getDate1() {
        return date1;
    }

    public void setDate1(Instant date1) {
        this.date1 = date1;
    }

    public Instant getDate2() {
        return date2;
    }

    public void setDate2(Instant date2) {
        this.date2 = date2;
    }

    public Instant getDate3() {
        return date3;
    }

    public void setDate3(Instant date3) {
        this.date3 = date3;
    }

    public Instant getDate4() {
        return date4;
    }

    public void setDate4(Instant date4) {
        this.date4 = date4;
    }

    public Boolean getBool0() {
        return bool0;
    }

    public void setBool0(Boolean bool0) {
        this.bool0 = bool0;
    }

    public Boolean getBool1() {
        return bool1;
    }

    public void setBool1(Boolean bool1) {
        this.bool1 = bool1;
    }

    public Boolean getBool2() {
        return bool2;
    }

    public void setBool2(Boolean bool2) {
        this.bool2 = bool2;
    }

    public Boolean getBool3() {
        return bool3;
    }

    public void setBool3(Boolean bool3) {
        this.bool3 = bool3;
    }

    public Boolean getBool4() {
        return bool4;
    }

    public void setBool4(Boolean bool4) {
        this.bool4 = bool4;
    }
}
