package com.zlsoft.award.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zlsoft.domain.Member;
import com.zlsoft.utils.domain.AbstractBaseEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 奖项申报信息
 */
@Entity
@Table(name = "d_declare")
public class Declare extends AbstractBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="declare_id_generator")
    @TableGenerator(name = "declare_id_generator",
            table="m_id",
            pkColumnName="pk_name",
            valueColumnName="pk_value",
            pkColumnValue="declare_pk",
            initialValue = 10000,
            allocationSize=1
    )
    private Long id;

//    /**
//     * 奖项id
//     */
//    private Long awardId;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="awardId")
    private Award award;
    
    @OneToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name="userId",referencedColumnName = "userId")
    private Member member;

    /**
     * 申报状态
     */
    private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Award getAward() {
		return award;
	}

	public void setAward(Award award) {
		this.award = award;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
    
    
}
