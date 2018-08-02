package com.zlsoft.common.service;

import com.zlsoft.domain.FileMetadata;
import com.zlsoft.domain.Invoice;
import com.zlsoft.domain.Member;
import com.zlsoft.domain.Order;
import com.zlsoft.utils.service.SimpleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface OrderService extends SimpleService<Order, Long> {

    Page<Order> findByMemberId(Long memberId, Pageable pageable);

    Optional<Order> findOneByOrderNo(String orderNo);

    Order save(Order payment, Member member, FileMetadata fileMetadata);

    Order save(Order payment, Invoice invoice);
}
