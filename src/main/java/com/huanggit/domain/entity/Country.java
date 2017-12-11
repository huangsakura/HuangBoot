package com.huanggit.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.huanggit.domain.entity.base.BaseEntity;
import lombok.Data;

/**
 * Created by huang on 2017-11-20-0020.
 */
@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Country extends BaseEntity {

    private String alpha2Code;

    private String alpha3Code;

    private String name;

    private String fullName;

    private String chineseName;

    private String chineseFullName;

    private String capitalName;

    private String capitalChineseName;

    private Integer population;

    private String continentCode;

    /**
     * 国家面积，（平方公里）
     */
    private String area;

    private String nationalFlag;
}
