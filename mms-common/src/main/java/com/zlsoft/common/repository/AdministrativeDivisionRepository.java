package com.zlsoft.common.repository;

import com.zlsoft.domain.AdministrativeDivision;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministrativeDivisionRepository extends JpaRepository<AdministrativeDivision, Long>, BaseRepository<AdministrativeDivision, Long> {
}
