package com.zlsoft.common.repository;

import com.zlsoft.domain.MeetingDues;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MeetingDuesRepository extends JpaRepository<MeetingDues, Long>,
        JpaSpecificationExecutor<MeetingDues>,
        BaseRepository<MeetingDues, Long> {

    Page<MeetingDues> findByMeetingId(Long meetingId, Pageable pageable);
    void deleteByMeetingId(Long meetingId);

}
