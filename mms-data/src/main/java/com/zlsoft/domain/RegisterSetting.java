package com.zlsoft.domain;

import javax.persistence.*;

@Entity
@Table(name = "t_register_setting")
public class RegisterSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="t_register_setting_id_generator")
    @TableGenerator(name = "t_register_setting_id_generator",
            table="m_id",
            pkColumnName="pk_name",
            valueColumnName="pk_value",
            pkColumnValue="t_register_setting_pk",
            initialValue = 10000,
            allocationSize=1
    )
    private Long id;

    /**
     * 会议id
     */
    private Long meetingId;

    /**
     * 姓名
     */
    @Column(length = 64)
    private String name;
}
