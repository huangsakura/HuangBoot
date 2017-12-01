package com.huanggit.general.dto.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by huang on 2017-12-01-0001.
 */
@Data
public class PageInfo<T> implements Serializable {

    /**
     * 每一页的条数
     */
    private Integer pageSize = 20;

    /**
     * 当前页的页码
     */
    private Integer currentPage = 1;

    /**
     * 当前页的内容
     */
    private List<T> pageResult;

    /**
     * 记录总条数
     */
    private Long totalCount = 0L;

    /**
     * 记录总页数
     */
    private Long totalPage =
            (0 == pageSize) ? 0L : ((totalCount % pageSize) == 0) ? totalCount / pageSize : totalCount / pageSize + 1;
}
