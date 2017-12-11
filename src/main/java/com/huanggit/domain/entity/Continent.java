package com.huanggit.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.huanggit.annotation.MybatisColumn;
import com.huanggit.domain.entity.base.BaseEntity;
import lombok.Data;

/**
 * Created by huang on 2017-11-20-0020.
 */
@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Continent extends BaseEntity {

    @MybatisColumn(length = 2,nullable = false)
    private String code;

    @MybatisColumn(length = 20,nullable = false)
    private String name;

    @MybatisColumn(length = 20,nullable = false)
    private String chineseName;
}
