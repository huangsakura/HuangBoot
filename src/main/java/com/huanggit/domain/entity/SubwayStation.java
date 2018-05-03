package com.huanggit.domain.entity;

import com.huanggit.annotation.ColumnConstraint;
import com.huanggit.domain.entity.base.BaseEntity;
import lombok.Data;

/**
 * Created by huang on 2017-12-18-0018.
 */
@Data
public class SubwayStation extends BaseEntity {

    /**
     * 地铁站全局唯一编号
     */
    @ColumnConstraint(minLength = 7,maxLength = 7,nullable = false,allowBlank = false)
    private String stationCode;

    /**
     * 地铁站英语名
     */
    @ColumnConstraint(nullable = false,allowBlank = false)
    private String englishName;

    /**
     * 地铁站中文名
     */
    @ColumnConstraint(nullable = false,allowBlank = false)
    private String chineseName;

    /**
     * 能容纳的最大人数
     */
    @ColumnConstraint(min = 1,nullable = false,minLength = 1,maxLength = 10)
    private Integer maxPassenger;
}
