package com.huanggit.domain.entity;

import com.huanggit.annotation.ColumnConstraint;
import com.huanggit.domain.entity.base.BaseEntity;
import com.huanggit.enumeration.account.TransCode;
import com.huanggit.general.dto.common.Money;
import lombok.Data;

/**
 * Created by huang on 2018-04-27-0027.
 */
@Data
public class AccountChange extends BaseEntity {

    @ColumnConstraint(maxLength = 3,minLength = 3,nullable = false)
    private String countryAlpha3Code;

    @ColumnConstraint(maxLength = 16,nullable = false)
    private Money amountBefore;

    @ColumnConstraint(maxLength = 16,nullable = false)
    private Money amount;

    @ColumnConstraint(maxLength = 16,nullable = false)
    private Money amountAfter;

    @ColumnConstraint(nullable = false)
    private TransCode transCode;

    @ColumnConstraint(maxLength = 3,minLength = 3)
    private String refCountryAlpha3Code;
}
