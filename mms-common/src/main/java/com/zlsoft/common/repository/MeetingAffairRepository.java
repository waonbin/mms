package com.zlsoft.common.repository;

import com.zlsoft.domain.MeetingAffair;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MeetingAffairRepository extends JpaRepository<MeetingAffair, Long>,
        JpaSpecificationExecutor<MeetingAffair>,
        BaseRepository<MeetingAffair, Long> {
    void deleteByMeetingId(Long meetingId);
}
