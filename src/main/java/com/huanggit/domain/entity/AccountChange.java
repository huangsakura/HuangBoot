package com.huanggit.domain.entity;

import com.huanggit.annotation.MybatisColumn;
import com.huanggit.domain.entity.base.BaseEntity;
import com.huanggit.general.dto.common.Money;
import lombok.Data;

/**
 * Created by huang on 2018-04-27-0027.
 */
@Data
public class AccountChange extends BaseEntity {

    @MybatisColumn(length = 3,nullable = false)
    private String countryAlpha3Code;

    private Money amountBefore;

    private Money amount;

    private Money amountAfter;
}
