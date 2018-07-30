package com.zlsoft.common.repository;

import com.zlsoft.domain.MeetingRegisterSetting;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MeetingRegisterSettingRepository extends JpaRepository<MeetingRegisterSetting, Long>,
        JpaSpecificationExecutor<MeetingRegisterSetting>,
        BaseRepository<MeetingRegisterSetting, Long> {
}
