package com.huanggit.domain.entity;

import com.huanggit.annotation.ColumnConstraint;
import com.huanggit.domain.entity.base.BaseEntity;
import com.huanggit.general.dto.common.Money;
import lombok.Data;

/**
 * Created by huang on 2018-04-27-0027.
 */
@Data
public class Account extends BaseEntity {

    @ColumnConstraint(maxLength = 3,minLength = 3,nullable = false)
    private String countryAlpha3Code;

    @ColumnConstraint(maxLength = 16,nullable = false)
    private Money amount;
}
