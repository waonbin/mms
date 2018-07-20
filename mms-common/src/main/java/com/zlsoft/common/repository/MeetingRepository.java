package com.zlsoft.common.repository;

import com.zlsoft.domain.Meeting;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MeetingRepository extends JpaRepository<Meeting, Long>,
        JpaSpecificationExecutor<Meeting>,
        BaseRepository<Meeting, Long> {
}
