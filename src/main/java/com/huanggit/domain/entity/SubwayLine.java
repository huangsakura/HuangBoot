package com.huanggit.domain.entity;

import com.huanggit.domain.entity.base.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * Created by huang on 2017-12-18-0018.
 */
@Data
public class SubwayLine extends BaseEntity {

    /**
     * 线路序号
     */
    private Integer lineNumber;

    /**
     * 线路中文名
     */
    private String lineChineseName;

    /**
     * 开通时间
     */
    private Date openDate;
}
