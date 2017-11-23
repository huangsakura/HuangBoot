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
    @Column(unique = true)
    private String countryCode;

    @NotBlank
    private String countryName;

    @NotBlank
    private String countryFullName;

    @NotBlank
    private String countryChineseName;

    @NotBlank
    private String countryChineseFullName;

    @NotBlank
    private String capitalName;

    @NotBlank
    private String capitalChineseName;

    private Integer population = new Integer(0);

    @NotBlank
    private String continentCode;

    /**
     * 国家面积，（平方公里）
     */
    @NotBlank
    private String countrySize;

    @JsonIgnore
    @NotNull
    private Date createTime;
}
