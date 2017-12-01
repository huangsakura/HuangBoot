package com.huanggit.domain.dao.base;

import com.huanggit.domain.entity.base.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by huang on 2017-12-01-0001.
 */
public interface BaseJpaDao<T extends BaseEntity, ID extends Serializable> extends JpaRepository<T, ID>, BaseDao<T> {
}
