package com.huanggit.aspect;

import com.huanggit.annotation.ColumnConstraint;
import com.huanggit.enumeration.common.ResultCode;
import com.huanggit.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.math.BigDecimal;

/**
 * Created by huang on 2017-12-11-0011.
 */
@Aspect
@Slf4j
@Component
public class MybatisAop {

    private enum Type {
        INSERT,UPDATE
    }

    /**
     * 匹配 com.huanggit.service 包下的以insert开头的方法
     */
    @Pointcut(value = "execution(* com.huanggit.service..*insert*(..))")
    private void insertMybatisAop(){}

    /**
     * 匹配 com.huanggit.service 包下的以update开头的方法
     */
    @Pointcut(value = "execution(* com.huanggit.service..*update*(..))")
    private void updateMybatisAop(){}

    @Before(value = "insertMybatisAop()")
    public void insertJudgeBefore(JoinPoint joinPoint) {
        judgeBefore(joinPoint.getArgs(),Type.INSERT);
    }

    @Before(value = "updateMybatisAop()")
    public void updateJudgeBefore(JoinPoint joinPoint) {
        judgeBefore(joinPoint.getArgs(),Type.UPDATE);
    }

    private void judgeBefore(Object[] args,Type type) {
        for (Object o : args) {
            Class c = o.getClass();
            for (Field field : c.getDeclaredFields()) {
                if (field.isAnnotationPresent(ColumnConstraint.class)) {
                    ColumnConstraint columnConstraint = field.getAnnotation(ColumnConstraint.class);
                    field.setAccessible(true);
                    String value = null;
                    try {
                        value = (String)field.get(o);
                    } catch (IllegalAccessException e) {
                        throw new BusinessException("无法访问表"+c.getName()+"的"+field.getName()+"字段",ResultCode.FIELD_CAN_NOT_ACCESS);
                    }
                    if (!columnConstraint.nullable() && value == null) {
                        throw new BusinessException("表"+c.getName()+"的"+field.getName()+"字段不能为空",ResultCode.FIELD_CAN_NOT_NULL);
                    }
                    if (value != null) {
                        if (value.length() > columnConstraint.minLength()) {
                            throw new BusinessException("表"+c.getName()+"的"+field.getName()+"字段超长",ResultCode.FIELD_OVER_LENGTH);
                        }
                        if (Long.class.equals(field.getType()) || Integer.class.equals(field.getType()) || BigDecimal.class.equals(field.getType())) {
                            if (Long.valueOf(value) < columnConstraint.min()) {
                                throw new BusinessException("表"+c.getName()+"的"+field.getName()+"字段的值不能小于"+columnConstraint.min(),ResultCode.FIELD_UNDER_MIN);
                            }
                        }
                    }
                }
            }
        }
    }
}
