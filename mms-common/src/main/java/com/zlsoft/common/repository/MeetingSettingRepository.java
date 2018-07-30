package com.zlsoft.common.repository;

import com.zlsoft.domain.MeetingSetting;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MeetingSettingRepository extends JpaRepository<MeetingSetting, Long>,
        JpaSpecificationExecutor<MeetingSetting>,
        BaseRepository<MeetingSetting, Long> {

    void deleteByMeetingId(Long meetingId);
}
