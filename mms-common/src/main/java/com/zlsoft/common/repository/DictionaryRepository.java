package com.zlsoft.common.repository;

import com.zlsoft.domain.Dictionary;
import com.zlsoft.utils.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DictionaryRepository extends JpaRepository<Dictionary, Long>, BaseRepository<Dictionary, Long> {
}
