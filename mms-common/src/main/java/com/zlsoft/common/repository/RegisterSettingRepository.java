package com.zlsoft.common.repository;

import com.zlsoft.domain.RegisterSetting;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RegisterSettingRepository extends JpaRepository<RegisterSetting, Long>,
        JpaSpecificationExecutor<RegisterSetting>,
        BaseRepository<RegisterSetting, Long> {
}
