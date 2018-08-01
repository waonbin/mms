package com.zlsoft.common.repository;

import com.zlsoft.domain.MeetingDues;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface MeetingDuesRepository extends JpaRepository<MeetingDues, Long>,
        JpaSpecificationExecutor<MeetingDues>,
        BaseRepository<MeetingDues, Long> {

    List<MeetingDues> findByMeetingId(Long meetingId);
    void deleteByMeetingId(Long meetingId);

}
