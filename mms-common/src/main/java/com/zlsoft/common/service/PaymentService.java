package com.zlsoft.common.service;

import com.zlsoft.domain.Payment;
import com.zlsoft.utils.service.SimpleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PaymentService extends SimpleService<Payment, Long> {

    Page<Payment> findByMemberId(Long memberId, Pageable pageable);
}
