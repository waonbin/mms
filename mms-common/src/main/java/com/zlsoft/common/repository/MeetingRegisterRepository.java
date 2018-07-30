package com.zlsoft.common.repository;

import com.zlsoft.domain.MeetingRegister;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MeetingRegisterRepository extends JpaRepository<MeetingRegister, Long>,
        JpaSpecificationExecutor<MeetingRegister>,
        BaseRepository<MeetingRegister, Long> {
}
