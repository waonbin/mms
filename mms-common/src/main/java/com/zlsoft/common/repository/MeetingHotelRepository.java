package com.zlsoft.common.repository;

import com.zlsoft.domain.MeetingHotel;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MeetingHotelRepository extends JpaRepository<MeetingHotel, Long>,
        JpaSpecificationExecutor<MeetingHotel>,
        BaseRepository<MeetingHotel, Long> {
    void deleteByMeetingId(Long meetingId);
}
