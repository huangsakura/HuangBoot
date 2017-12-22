package com.huanggit.domain.entity;

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
    private String stationCode;

    /**
     * 地铁站英语名
     */
    private String englishName;

    /**
     * 地铁站中文名
     */
    private String chineseName;

    /**
     * 能容纳的最大人数
     */
    private Integer maxPassenger;
}
