package com.zlsoft.core.service;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface SimpleService<T, ID extends Serializable> {

    JpaRepository<T, ID> getRepository();

    void deleteById(ID id);

    void delete(T entity);

    void deleteAll(Iterable<? extends T> entities);

    void deleteAll();

    void deleteInBatch(Iterable<T> var1);

    void deleteAllInBatch();

    Optional<T> findById(ID var1);

    List<T> findAll();

    List<T> findAll(Sort var1);

    <S extends T> List<S> findAll(Example<S> var1);

    <S extends T> List<S> findAll(Example<S> var1, Sort var2);

    Page<T> findAll(Pageable var1);

    void flush();

    <S extends T> S save(S entity);

    <S extends T> Iterable<S> saveAll(Iterable<S> var1);

    <S extends T> S saveAndFlush(S var1);

    Optional<T> findOne(@Nullable Specification<T> var1);

    List<T> findAll(Specification<T> spec);

    Page<T> findAll(Specification<T> spec, Pageable pageable);

    List<T> findAll(Specification<T> spec, Sort sort);

    long count(Specification<T> spec);
}
