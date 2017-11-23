package com.huanggit.annotation;

import java.lang.annotation.*;

/**
 * Created by huang on 2017-11-23-0023.
 */
@Documented
@Target(value = {ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface OperationLog {
}
