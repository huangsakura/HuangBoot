package com.huanggit.annotation;

import org.apache.commons.lang3.StringUtils;

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
        validatedBy = ColumnConstraint.TypeChecker.class
)
public @interface ColumnConstraint {

    int minLength() default 0;

    int maxLength() default 0;

    boolean nullable() default true;

    long min() default 0;

    boolean allowBlank() default true;

    public static class TypeChecker implements ConstraintValidator<ColumnConstraint,Object> {
        private ColumnConstraint t_mybatisColumn;

        @Override
        public void initialize(ColumnConstraint annotation) {
            t_mybatisColumn = annotation;
        }

        @Override
        public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
            if (!t_mybatisColumn.nullable() && (o == null)) {
                return false;
            }
            if (o != null) {
                if (o instanceof Integer || o instanceof Long || o instanceof BigDecimal) {
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

                if (t_mybatisColumn.maxLength() > 0) {
                    if (o.toString().length() > t_mybatisColumn.maxLength()) {
                        return false;
                    }
                }

                if (t_mybatisColumn.minLength() > 0) {
                    if (o.toString().length() < t_mybatisColumn.minLength()) {
                        return false;
                    }
                }

                if (o instanceof String) {
                    if (!t_mybatisColumn.allowBlank() && StringUtils.isBlank((String)o)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
