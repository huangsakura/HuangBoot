package com.huanggit.domain.entity;

import com.huanggit.domain.entity.base.BaseEntity;
import lombok.Data;

/**
 * Created by huang on 2017-12-22-0022.
 */
@Data
public class SysUser extends BaseEntity {

    private String userName;

    private String password;
}
