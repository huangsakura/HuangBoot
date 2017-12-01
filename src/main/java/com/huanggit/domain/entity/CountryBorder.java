package com.huanggit.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.huanggit.domain.entity.base.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

/**
 * Created by huang on 2017-11-29-0029.
 */
@Table
@Entity(name = "Country_Border")
@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class CountryBorder extends BaseEntity {

    @NotBlank
    private String hostAlpha3Code;

    @NotBlank
    private String guestAlpha3Code;
}
