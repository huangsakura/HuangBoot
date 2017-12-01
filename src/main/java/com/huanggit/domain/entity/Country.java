package com.huanggit.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.huanggit.domain.entity.base.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

/**
 * Created by huang on 2017-11-20-0020.
 */
@Table
@Entity(name = "country")
@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Country extends BaseEntity {

    @NotBlank
    private String alpha2Code;

    @NotBlank
    private String alpha3Code;

    @NotBlank
    private String name;

    private String fullName;

    private String chineseName;

    private String chineseFullName;

    @NotBlank
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
