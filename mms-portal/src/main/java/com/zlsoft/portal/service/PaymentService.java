package com.zlsoft.portal.service;

import com.zlsoft.portal.domain.Payment;
import com.zlsoft.utils.service.SimpleService;

import java.util.List;

public interface PaymentService extends SimpleService<Payment, Long> {

    List<Payment> findByMemberId(Long memberId);
}
