package com.zlsoft.common.repository;

import com.zlsoft.domain.PaperAudit;
import com.zlsoft.domain.Order;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long>,
        JpaSpecificationExecutor<PaperAudit>,
        BaseRepository<Order, Long> {

    @Query(value = "select p from Order p where p.memberId=:memberId")
    Page<Order> findByMemberId(@Param("memberId") Long memberId, Pageable pageable);

    Optional<Order> findOneByOrderNo(String orderNo);
}
