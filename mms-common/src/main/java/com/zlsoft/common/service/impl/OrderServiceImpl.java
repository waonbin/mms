package com.zlsoft.common.service.impl;

import com.zlsoft.common.repository.OrderRepository;
import com.zlsoft.common.service.FileMetadataService;
import com.zlsoft.common.service.InvoiceService;
import com.zlsoft.common.service.MemberService;
import com.zlsoft.common.service.OrderService;
import com.zlsoft.domain.FileMetadata;
import com.zlsoft.domain.Invoice;
import com.zlsoft.domain.Member;
import com.zlsoft.domain.Order;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Optional;

@Transactional
@Service("orderService")
public class OrderServiceImpl extends BaseSimpleService<Order, Long> implements OrderService {

    @Inject
    private MemberService memberService;

    @Inject
    private FileMetadataService fileMetadataService;

    @Inject
    private InvoiceService invoiceService;

    @Transactional(readOnly = true)
    @Override
    public Page<Order> findByMemberId(Long memberId, Pageable pageable) {
        return ((OrderRepository)this.getRepository()).findByMemberId(memberId, pageable);
    }

    @Override
    public Optional<Order> findOneByOrderNo(String orderNo) {
        return ((OrderRepository)this.getRepository()).findOneByOrderNo(orderNo);
    }

    @Override
    public Order save(Order payment, Member member, FileMetadata fileMetadata) {
        this.memberService.save(member);
        this.fileMetadataService.save(fileMetadata);
        return this.save(payment);
    }

    @Override
    public Order save(Order payment, Invoice invoice) {
        this.invoiceService.save(invoice);
        return this.save(payment);
    }
}
