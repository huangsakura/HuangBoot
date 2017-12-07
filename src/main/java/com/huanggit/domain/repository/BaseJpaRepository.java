package com.huanggit.domain.repository;

import com.huanggit.domain.entity.base.BaseEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by huang on 2017-12-07-0007.
 */
public interface BaseJpaRepository<T extends BaseEntity> {

    public List<T> list(Map<String,Object> paramMap, Map<String,Boolean> sortMap);
}
