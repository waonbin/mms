package com.zlsoft.common.repository;

import com.zlsoft.domain.MeetingEnrollment;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingEnrollmentRepository extends JpaRepository<MeetingEnrollment, Long>, BaseRepository<MeetingEnrollment, Long> {
}
