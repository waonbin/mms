package com.zlsoft.common.repository;

import com.zlsoft.domain.MeetingEnrollment;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MeetingEnrollmentRepository extends JpaRepository<MeetingEnrollment, Long>,
        JpaSpecificationExecutor<MeetingEnrollment>,
        BaseRepository<MeetingEnrollment, Long> {
}
