package com.zlsoft.common.repository;

import com.zlsoft.domain.MeetingPlace;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface MeetingPlaceRepository extends JpaRepository<MeetingPlace, Long>,
        JpaSpecificationExecutor<MeetingPlace>,
        BaseRepository<MeetingPlace, Long> {

    Page<MeetingPlace> findByMeetingId(Long meetingId, Pageable pageable);
    void deleteByMeetingId(Long meetingId);

}
