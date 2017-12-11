package com.huanggit.annotation;

import java.lang.annotation.*;

/**
 * Created by huang on 2017-12-11-0011.
 */
@Documented
@Target(value = {ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MybatisColumn {

    int length();

    boolean nullable() default true;
}
