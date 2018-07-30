package com.zlsoft.common.repository;

import com.zlsoft.domain.RegisterSettingItem;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RegisterSettingItemRepository extends JpaRepository<RegisterSettingItem, Long>,
        JpaSpecificationExecutor<RegisterSettingItem>,
        BaseRepository<RegisterSettingItem, Long> {
}
