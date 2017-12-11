package com.huanggit.aspect;

import com.huanggit.annotation.MybatisColumn;
import com.huanggit.enumeration.common.ResultCode;
import com.huanggit.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * Created by huang on 2017-12-11-0011.
 */
@Aspect
@Slf4j
@Component
public class MybatisAop {

    @Pointcut(value = "execution(* com.huanggit.service..*insert*(..))")
    private void insertMybatisAop(){}

    @Pointcut(value = "execution(* com.huanggit.service..*update*(..))")
    private void updateMybatisAop(){}

    @Before(value = "insertMybatisAop()")
    public void insertJudgeBefore(JoinPoint joinPoint) {
        judgeBefore(joinPoint.getArgs());
    }

    @Before(value = "updateMybatisAop()")
    public void updateJudgeBefore(JoinPoint joinPoint) {
        judgeBefore(joinPoint.getArgs());
    }

    private void judgeBefore(Object[] args) {
        for (Object o : args) {
            Class c = o.getClass();
            for (Field field : c.getDeclaredFields()) {
                if (field.isAnnotationPresent(MybatisColumn.class)) {
                    if (String.class.equals(field.getType()) || Integer.class.equals(field.getType())) {
                        MybatisColumn mybatisColumn = field.getAnnotation(MybatisColumn.class);
                        field.setAccessible(true);
                        String value = null;
                        try {
                            value = (String)field.get(o);
                        } catch (IllegalAccessException e) {
                            throw new BusinessException("无法访问表"+c.getName()+"的"+field.getName()+"字段",ResultCode.FIELD_CAN_NOT_ACCESS);
                        }
                        if (mybatisColumn.nullable() && value == null) {
                            throw new BusinessException("表"+c.getName()+"的"+field.getName()+"字段不能为空",ResultCode.FIELD_CAN_NOT_NULL);
                        }
                        if (value.length() > mybatisColumn.length()) {
                            throw new BusinessException("表"+c.getName()+"的"+field.getName()+"字段超长",ResultCode.FIELD_OVER_LENGTH);
                        }
                    }
                }
            }
        }
    }
}
