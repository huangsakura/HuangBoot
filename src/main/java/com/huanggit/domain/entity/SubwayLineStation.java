package com.huanggit.domain.entity;

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
    private String stationCode;

    /**
     * 线路序号
     */
    private Integer lineNumber;

    /**
     * 开通时间
     */
    private Date openDate;

    /**
     * 当前地铁站在当前线路中的序号
     */
    private Integer stationSortNumber;

    /**
     * 与上一站的距离（单位 米）
     */
    private Long awayFromPrevStation;
}
