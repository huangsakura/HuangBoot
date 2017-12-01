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
@Entity(name = "continent")
@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Continent extends BaseEntity {

    @NotBlank
    @Column(unique = true)
    private String code;

    @NotBlank
    private String name;

    @NotBlank
    private String chineseName;
}
