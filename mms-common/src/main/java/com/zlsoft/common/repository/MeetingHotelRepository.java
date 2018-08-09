package com.zlsoft.common.repository;

import com.zlsoft.domain.MeetingHotel;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface MeetingHotelRepository extends JpaRepository<MeetingHotel, Long>,
        JpaSpecificationExecutor<MeetingHotel>,
        BaseRepository<MeetingHotel, Long> {

    Page<MeetingHotel> findByMeetingId(Long meetingId, Pageable pageable);
    void deleteByMeetingId(Long meetingId);

}
