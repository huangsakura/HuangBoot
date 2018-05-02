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

    public static class TypeChecker implements ConstraintValidator<MybatisColumn,Object> {
        private MybatisColumn t_mybatisColumn;

        @Override
        public void initialize(MybatisColumn annotation) {
            t_mybatisColumn = annotation;
        }

        @Override
        public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
            if (!t_mybatisColumn.nullable()) {
                if (o == null) {
                    return false;
                }
            }

            if (o instanceof String || o instanceof Integer || o instanceof Long || o instanceof BigDecimal) {
                BigDecimal bigDecimal = null;
                if (o instanceof BigDecimal) {
                    bigDecimal = (BigDecimal)o;
                } else if (o instanceof Integer || o instanceof Long) {
                    bigDecimal = new BigDecimal(o.toString());
                }
                if (bigDecimal.compareTo(new BigDecimal(t_mybatisColumn.min())) < 0) {
                    return false;
                }
            }
            //constraintValidatorContext.buildConstraintViolationWithTemplate("").addConstraintViolation();
            return false;
        }
    }
}
