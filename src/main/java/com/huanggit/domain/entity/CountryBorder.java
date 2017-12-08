package com.huanggit.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.huanggit.domain.entity.base.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by huang on 2017-11-29-0029.
 */
@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
@Entity
@Table(name = "Country_Border")
public class CountryBorder extends BaseEntity {

    private String hostAlpha3Code;

    private String guestAlpha3Code;
}
