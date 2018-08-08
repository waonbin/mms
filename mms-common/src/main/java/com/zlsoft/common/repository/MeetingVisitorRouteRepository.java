package com.zlsoft.common.repository;

import com.zlsoft.domain.MeetingVisitorRoute;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface MeetingVisitorRouteRepository extends JpaRepository<MeetingVisitorRoute, Long>,
        JpaSpecificationExecutor<MeetingVisitorRoute>,
        BaseRepository<MeetingVisitorRoute, Long> {

    Page<MeetingVisitorRoute> findByMeetingId(Long meetingId, Pageable pageable);
    void deleteByMeetingId(Long meetingId);

}
