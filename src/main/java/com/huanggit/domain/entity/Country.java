package com.huanggit.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.huanggit.annotation.MybatisColumn;
import com.huanggit.domain.entity.base.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * Created by huang on 2017-11-20-0020.
 */
@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Country extends BaseEntity {

    @MybatisColumn(length = 2,nullable = false)
    private String alpha2Code;

    @MybatisColumn(length = 3,nullable = false)
    private String alpha3Code;

    @MybatisColumn(length = 128,nullable = false)
    private String name;

    @MybatisColumn(length = 128)
    private String fullName;

    @MybatisColumn(length = 32)
    private String chineseName;

    @MybatisColumn(length = 64)
    private String chineseFullName;

    @MybatisColumn(length = 32,nullable = false)
    private String capitalName;

    @MybatisColumn(length = 32)
    private String capitalChineseName;

    @MybatisColumn(length = 10,min = 1)
    private Integer population;

    @MybatisColumn(length = 2,nullable = false)
    private String continentCode;

    /**
     * 国家面积，（平方公里）
     */
    @MybatisColumn(length = 10)
    private String area;

    @MybatisColumn(length = 64)
    private String nationalFlag;

    @MybatisColumn
    private Date nationalDay;
}
