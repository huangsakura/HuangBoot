package com.huanggit.domain.repository.base;

import com.huanggit.domain.entity.base.BaseEntity;
import com.huanggit.general.dto.common.PageInfo;

/**
 * Created by huang on 2017-12-01-0001.
 */
public interface UserDefinedRepository<T extends BaseEntity> {

    PageInfo<T> queryPage(PageInfo pageInfo);
}
