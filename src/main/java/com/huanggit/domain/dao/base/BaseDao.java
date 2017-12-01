package com.huanggit.domain.dao.base;

import com.huanggit.general.dto.common.PageInfo;

import java.util.Map;

/**
 * Created by huang on 2017-12-01-0001.
 */
public interface BaseDao<T> {
    PageInfo<T> query(PageInfo<T> pageInfo, Map<String, Object> var2, Map<String, Boolean> var3);
}
