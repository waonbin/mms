package com.zlsoft.common.repository;

import com.zlsoft.domain.MeetingVisitorRoute;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MeetingVisitorRouteRepository extends JpaRepository<MeetingVisitorRoute, Long>,
        JpaSpecificationExecutor<MeetingVisitorRoute>,
        BaseRepository<MeetingVisitorRoute, Long> {
    void deleteByMeetingId(Long meetingId);
}
