package com.huanggit.annotation;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.*;
import java.math.BigDecimal;

/**
 * Created by huang on 2017-12-11-0011.
 */
@Documented
@Target(value = {ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = MybatisColumn.TypeChecker.class
)
public @interface MybatisColumn {

    int length() default 0;

    boolean nullable() default true;

    long min() default 0;

    class TypeChecker implements ConstraintValidator<MybatisColumn,Object> {
        @Override
        public void initialize(MybatisColumn annotation) {

        }

        @Override
        public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
            if (o instanceof String || o instanceof Integer || o instanceof Long || o instanceof BigDecimal) {
                return true;
            }
            constraintValidatorContext.buildConstraintViolationWithTemplate("").addConstraintViolation();
            return false;
        }
    }
}
