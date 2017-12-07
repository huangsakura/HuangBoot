package com.huanggit.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.huanggit.domain.entity.base.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by huang on 2017-11-20-0020.
 */
@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Entity
@Table(name = "Continent")
public class Continent extends BaseEntity {

    private String code;

    private String name;

    private String chineseName;
}
