package com.zlsoft.common.repository;

import com.zlsoft.domain.Invoice;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface InvoiceRepository extends JpaRepository<Invoice, Long>,
        JpaSpecificationExecutor<Invoice>,
        BaseRepository<Invoice, Long> {
}
