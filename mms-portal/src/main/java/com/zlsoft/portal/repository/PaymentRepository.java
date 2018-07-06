package com.zlsoft.portal.repository;

import com.zlsoft.portal.domain.Payment;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long>, BaseRepository<Payment, Long> {

    List<Payment> findByMemberId(Long memberId);
}
