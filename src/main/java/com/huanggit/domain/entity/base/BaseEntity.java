package com.huanggit.domain.entity.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by huang on 2017-12-01-0001.
 */
@Data
public abstract class BaseEntity implements Serializable {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @NotNull
    @Column(
            name = "create_time",
            columnDefinition = " timestamp  DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'"
    )
    private Date createTime;
}
