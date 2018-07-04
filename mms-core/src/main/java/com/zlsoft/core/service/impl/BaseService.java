package com.zlsoft.core.service.impl;

import com.zlsoft.core.repository.BaseRepository;

import javax.inject.Inject;
import java.io.Serializable;

public abstract class BaseService <T, ID extends Serializable> {

    @Inject
    protected BaseRepository<T, ID> repository;
}
