package com.huanggit.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.huanggit.annotation.ColumnConstraint;
import com.huanggit.domain.entity.base.BaseEntity;
import com.huanggit.util.DateUtil;
import lombok.Data;

import java.util.Date;

/**
 * Created by huang on 2017-11-20-0020.
 */
@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Country extends BaseEntity {

    @ColumnConstraint(maxLength = 2,minLength = 2,nullable = false)
    private String alpha2Code;

    @ColumnConstraint(maxLength = 3,minLength = 3,nullable = false)
    private String alpha3Code;

    @ColumnConstraint(maxLength = 128,nullable = false)
    private String name;

    @ColumnConstraint(maxLength = 128)
    private String fullName;

    @ColumnConstraint(maxLength = 32)
    private String chineseName;

    @ColumnConstraint(maxLength = 64)
    private String chineseFullName;

    @ColumnConstraint(maxLength = 32,nullable = false)
    private String capitalName;

    @ColumnConstraint(maxLength = 32)
    private String capitalChineseName;

    @ColumnConstraint(maxLength = 10,min = 1)
    private Integer population;

    @ColumnConstraint(maxLength = 2,minLength = 2,nullable = false)
    private String continentCode;

    /**
     * 国家面积，（平方公里）
     */
    @ColumnConstraint(maxLength = 10)
    private String area;

    @ColumnConstraint(maxLength = 64)
    private String nationalFlag;

    @JsonFormat(pattern = DateUtil.CHINESE_DATE_FORMAT_LINE)
    private Date nationalDay;
}
