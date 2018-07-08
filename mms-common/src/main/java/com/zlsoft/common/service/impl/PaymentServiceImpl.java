package com.zlsoft.common.service.impl;

import com.zlsoft.common.repository.PaymentRepository;
import com.zlsoft.common.service.PaymentService;
import com.zlsoft.domain.Payment;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("paymentService")
public class PaymentServiceImpl extends BaseSimpleService<Payment, Long> implements PaymentService {

    @Override
    public List<Payment> findByMemberId(Long memberId) {
        return ((PaymentRepository)this.getRepository()).findByMemberId(memberId);
    }
}
