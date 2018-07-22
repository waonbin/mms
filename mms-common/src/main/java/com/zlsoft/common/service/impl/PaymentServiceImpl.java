package com.zlsoft.common.service.impl;

import com.zlsoft.common.repository.PaymentRepository;
import com.zlsoft.common.service.FileMetadataService;
import com.zlsoft.common.service.MemberService;
import com.zlsoft.common.service.PaymentService;
import com.zlsoft.domain.FileMetadata;
import com.zlsoft.domain.Member;
import com.zlsoft.domain.Payment;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Transactional
@Service("paymentService")
public class PaymentServiceImpl extends BaseSimpleService<Payment, Long> implements PaymentService {

    @Inject
    private MemberService memberService;

    @Inject
    private FileMetadataService fileMetadataService;

    @Transactional(readOnly = true)
    @Override
    public Page<Payment> findByMemberId(Long memberId, Pageable pageable) {
        return ((PaymentRepository)this.getRepository()).findByMemberId(memberId, pageable);
    }

    @Override
    public Payment save(Payment payment, Member member, FileMetadata fileMetadata) {
        this.memberService.save(member);
        this.fileMetadataService.save(fileMetadata);
        return this.save(payment);
    }
}
