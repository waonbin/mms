package com.zlsoft.common.service.impl;

import com.zlsoft.common.service.InvoiceService;
import com.zlsoft.domain.Invoice;
import com.zlsoft.utils.service.impl.BaseSimpleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("invoiceService")
public class InvoiceServiceImpl extends BaseSimpleService<Invoice, Long> implements InvoiceService {
}
