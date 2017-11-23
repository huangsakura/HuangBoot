package com.huanggit.aspect;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by huang on 2017-11-22-0022.
 */
@Aspect
@Slf4j
@Component
public class ControllerLogAop {

    @Pointcut(value = "execution(* com.huanggit.web..*.*(..))")
    private void controllerLogAop() {}

    @Before(value = "controllerLogAop()")
    public void writeLogIn(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        log.info("进入"+signature.getDeclaringTypeName()+"#"+signature.getName());
        HttpServletRequest request = (HttpServletRequest) RequestContextHolder.getRequestAttributes().resolveReference(RequestAttributes.REFERENCE_REQUEST);
        Enumeration<String> enumeration = request.getParameterNames();
        Map<String,String> parameterMap = new HashMap();
        while (enumeration.hasMoreElements()){
            String parameter = enumeration.nextElement();
            parameterMap.put(parameter,request.getParameter(parameter));
        }
        log.info("入参:"+ JSON.toJSONString(parameterMap));
    }
}
