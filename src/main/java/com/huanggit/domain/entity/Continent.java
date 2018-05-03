package com.huanggit.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.huanggit.annotation.ColumnConstraint;
import com.huanggit.domain.entity.base.BaseEntity;
import lombok.Data;

/**
 * Created by huang on 2017-11-20-0020.
 */
@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Continent extends BaseEntity {

    @ColumnConstraint(maxLength = 2,minLength = 2,nullable = false)
    private String code;

    @ColumnConstraint(maxLength = 20,nullable = false)
    private String name;

    @ColumnConstraint(maxLength = 20,nullable = false)
    private String chineseName;
}
