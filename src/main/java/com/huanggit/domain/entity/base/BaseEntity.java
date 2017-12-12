package com.huanggit.domain.entity.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by huang on 2017-12-01-0001.
 */
@Data
public abstract class BaseEntity implements Serializable {

    @JsonIgnore
    private Long id;

    @JsonIgnore
    private Date createTime = new Date();
}
