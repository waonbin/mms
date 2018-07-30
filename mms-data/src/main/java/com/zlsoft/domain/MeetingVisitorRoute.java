package com.zlsoft.domain;

import com.zlsoft.utils.domain.AbstractBaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "d_meeting_visitor_route")
public class MeetingVisitorRoute extends AbstractBaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="mtg_visitor_route_id_generator")
    @TableGenerator(name = "mtg_visitor_route_id_generator",
            table="m_id",
            pkColumnName="pk_name",
            valueColumnName="pk_value",
            pkColumnValue="mtg_visitor_route_pk",
            initialValue = 10000,
            allocationSize=1
    )
    private Long id;

    /**
     * 会议id
     */
    private Long meetingId;

    /**
     * 路线名称
     */
    @Column(length = 64)
    private String name;

    /**
     * 路线描述
     */
    @Column(columnDefinition = "TEXT")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Long meetingId) {
        this.meetingId = meetingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
