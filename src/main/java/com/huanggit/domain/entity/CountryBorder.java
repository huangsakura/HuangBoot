package com.huanggit.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.huanggit.annotation.MybatisColumn;
import com.huanggit.domain.entity.base.BaseEntity;
import lombok.Data;

/**
 * Created by huang on 2017-11-29-0029.
 */
@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class CountryBorder extends BaseEntity {

    @MybatisColumn(length = 3,nullable = false)
    private String hostAlpha3Code;

    @MybatisColumn(length = 3,nullable = false)
    private String guestAlpha3Code;
}
