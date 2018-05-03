package com.huanggit.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.huanggit.annotation.ColumnConstraint;
import com.huanggit.domain.entity.base.BaseEntity;
import lombok.Data;

/**
 * Created by huang on 2017-11-29-0029.
 */
@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class CountryBorder extends BaseEntity {

    @ColumnConstraint(maxLength = 3,minLength = 3,nullable = false)
    private String hostAlpha3Code;

    @ColumnConstraint(maxLength = 3,minLength = 3,nullable = false)
    private String guestAlpha3Code;
}
