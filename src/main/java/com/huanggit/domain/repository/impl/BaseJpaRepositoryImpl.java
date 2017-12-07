package com.huanggit.domain.repository.impl;

import com.huanggit.domain.entity.base.BaseEntity;
import com.huanggit.domain.repository.BaseJpaRepository;

import java.util.List;
import java.util.Map;

/**
 * Created by huang on 2017-12-07-0007.
 */
public class BaseJpaRepositoryImpl<T extends BaseEntity> implements BaseJpaRepository<T> {
    @Override
    public List<T> list(Map paramMap, Map sortMap) {
        return null;
    }
}
