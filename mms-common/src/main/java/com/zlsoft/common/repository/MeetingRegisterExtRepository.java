package com.zlsoft.common.repository;

import com.zlsoft.domain.MeetingRegisterExt;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MeetingRegisterExtRepository extends JpaRepository<MeetingRegisterExt, Long>,
        JpaSpecificationExecutor<MeetingRegisterExt>,
        BaseRepository<MeetingRegisterExt, Long> {
}
