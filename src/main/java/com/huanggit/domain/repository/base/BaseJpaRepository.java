package com.huanggit.domain.repository.base;

import com.huanggit.domain.entity.base.BaseEntity;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Map;

/**
 * Created by huang on 2017-12-07-0007.
 */
@NoRepositoryBean
public interface BaseJpaRepository<T extends BaseEntity> extends PagingAndSortingRepository<T,Long> {

    public List<T> list(Map<String,Object> paramMap, Map<String,Boolean> sortMap);
}
