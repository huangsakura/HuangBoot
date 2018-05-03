package com.huanggit.domain.entity;

import com.huanggit.annotation.ColumnConstraint;
import com.huanggit.domain.entity.base.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * Created by huang on 2017-12-18-0018.
 */
@Data
public class SubwayLineStation extends BaseEntity {

    /**
     * 地铁站全局唯一编号
     */
    @ColumnConstraint(minLength = 7,maxLength = 7,nullable = false,allowBlank = false)
    private String stationCode;

    /**
     * 线路序号
     */
    @ColumnConstraint(nullable = false)
    private Integer lineNumber;

    /**
     * 开通时间
     */
    private Date openDate;

    /**
     * 当前地铁站在当前线路中的序号
     */
    @ColumnConstraint(min = 1,nullable = false)
    private Integer stationSortNumber;

    /**
     * 与上一站的距离（单位 米）
     */
    @ColumnConstraint(min = 100,nullable = false,maxLength = 10)
    private Long awayFromPrevStation;
}
