package com.zlsoft.utils.service.impl;

import com.zlsoft.utils.service.SimpleService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Transactional
public abstract class BaseSimpleService<T, ID extends Serializable> extends BaseService<T, ID> implements SimpleService<T, ID> {

    @Override
    public JpaRepository<T, ID> getRepository() {
        return (JpaRepository<T, ID>) this.repository;
    }

    @Override
    public void deleteById(ID id) {
        this.getRepository().deleteById(id);
    }

    @Override
    public void delete(T entity) {
        this.getRepository().delete(entity);
    }

    @Override
    public void deleteAll(Iterable<? extends T> entities) {
        this.getRepository().deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        this.getRepository().deleteAll();
    }

    @Override
    public void deleteInBatch(Iterable<T> var1) {
        this.getRepository().deleteInBatch(var1);
    }

    @Override
    public void deleteAllInBatch() {
        this.getRepository().deleteAllInBatch();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<T> findById(ID var1) {
        return this.getRepository().findById(var1);
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return this.getRepository().findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<T> findAll(Sort var1) {
        return this.getRepository().findAll(var1);
    }

    @Override
    @Transactional(readOnly = true)
    public <S extends T> List<S> findAll(Example<S> var1) {
        return this.getRepository().findAll(var1);
    }

    @Override
    @Transactional(readOnly = true)
    public <S extends T> List<S> findAll(Example<S> var1, Sort var2) {
        return this.getRepository().findAll(var1, var2);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<T> findAll(Pageable var1) {
        return this.getRepository().findAll(var1);
    }

    @Override
    public void flush() {
        this.getRepository().flush();
    }

    @Override
    public <S extends T> S save(S entity) {
        return this.getRepository().save(entity);
    }

    @Override
    public <S extends T> Iterable<S> saveAll(Iterable<S> var1) {
        return this.getRepository().saveAll(var1);
    }

    @Override
    public <S extends T> S saveAndFlush(S var1) {
        return this.getRepository().saveAndFlush(var1);
    }

    @Override
    public Optional<T> findOne(@Nullable Specification<T> var1) {
        return ((JpaSpecificationExecutor<T>)this.getRepository()).findOne(var1);
    }

    @Override
    public List<T> findAll(Specification<T> spec) {
        return ((JpaSpecificationExecutor<T>)this.getRepository()).findAll(spec);
    }

    @Override
    public Page<T> findAll(Specification<T> spec, Pageable pageable) {
        return ((JpaSpecificationExecutor<T>)this.getRepository()).findAll(spec, pageable);
    }

    @Override
    public List<T> findAll(Specification<T> spec, Sort sort) {
        return ((JpaSpecificationExecutor<T>)this.getRepository()).findAll(spec, sort);
    }

    @Override
    public long count(Specification<T> spec) {
        return ((JpaSpecificationExecutor<T>)this.getRepository()).count(spec);
    }
}
