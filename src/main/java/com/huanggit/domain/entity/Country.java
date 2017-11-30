package com.huanggit.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by huang on 2017-11-20-0020.
 */
@Table
@Entity(name = "country")
@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Country {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @JsonIgnore
    @NotNull
    private Date createTime;
}
