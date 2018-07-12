package com.zlsoft.common.repository;

import com.zlsoft.domain.Payment;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PaymentRepository extends JpaRepository<Payment, Long>, BaseRepository<Payment, Long> {

    @Query(value = "select p from Payment p where p.memberId=:memberId")
    Page<Payment> findByMemberId(@Param("memberId") Long memberId, Pageable pageable);
}
