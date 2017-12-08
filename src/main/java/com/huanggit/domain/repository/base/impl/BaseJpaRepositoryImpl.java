package com.huanggit.domain.repository.base.impl;

import com.huanggit.domain.entity.base.BaseEntity;
import com.huanggit.domain.repository.base.BaseJpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;

/**
 * Created by huang on 2017-12-07-0007.
 */
public class BaseJpaRepositoryImpl<T extends BaseEntity> extends SimpleJpaRepository<T,Long> implements BaseJpaRepository<T> {

    private final Class<T> domainClass;
    private final EntityManager entityManager;

    public BaseJpaRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.domainClass = domainClass;
        this.entityManager = entityManager;
    }

    @Override
    public List<T> list(Map<String, Object> paramMap, Map<String, Boolean> sortMap) {
        return null;
    }
}
