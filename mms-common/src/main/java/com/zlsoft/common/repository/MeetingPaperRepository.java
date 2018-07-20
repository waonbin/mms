package com.zlsoft.common.repository;

import com.zlsoft.domain.MeetingPaper;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MeetingPaperRepository extends JpaRepository<MeetingPaper, Long>,
        JpaSpecificationExecutor<MeetingPaper>,
        BaseRepository<MeetingPaper, Long> {
}
