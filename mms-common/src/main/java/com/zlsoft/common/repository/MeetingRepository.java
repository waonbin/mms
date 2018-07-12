package com.zlsoft.common.repository;

import com.zlsoft.domain.Meeting;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Long>, BaseRepository<Meeting, Long> {
}
