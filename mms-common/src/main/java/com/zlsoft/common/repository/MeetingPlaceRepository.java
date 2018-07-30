package com.zlsoft.common.repository;

import com.zlsoft.domain.MeetingPlace;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MeetingPlaceRepository extends JpaRepository<MeetingPlace, Long>,
        JpaSpecificationExecutor<MeetingPlace>,
        BaseRepository<MeetingPlace, Long> {
    void deleteByMeetingId(Long meetingId);
}
