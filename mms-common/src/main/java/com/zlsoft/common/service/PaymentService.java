package com.zlsoft.common.service;

import com.zlsoft.domain.FileMetadata;
import com.zlsoft.domain.Invoice;
import com.zlsoft.domain.Member;
import com.zlsoft.domain.Payment;
import com.zlsoft.utils.service.SimpleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PaymentService extends SimpleService<Payment, Long> {

    Page<Payment> findByMemberId(Long memberId, Pageable pageable);

    Payment save(Payment payment, Member member, FileMetadata fileMetadata);

    Payment save(Payment payment, Invoice invoice);
}
