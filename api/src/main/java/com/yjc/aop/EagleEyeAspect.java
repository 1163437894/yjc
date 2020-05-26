package com.yjc.aop;


import com.alibaba.fastjson.JSON;
import com.yjc.anno.EagleEye;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;


/**
 * 请求切入
 *
 * @author yjc
 * @since 2020/5/26
 */
@Aspect
@Component
@Slf4j
public class EagleEyeAspect {


    @Pointcut("@annotation(com.yjc.anno.EagleEye)")
    public void eagleEye() {
    }


    @Around("eagleEye()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {

        //时间挫
        long beginTime = System.currentTimeMillis();


        //获取request 请求
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        EagleEye eagleEye = method.getAnnotation(EagleEye.class);

        //接口描述
        String desc = eagleEye.desc();

        log.info("===============请求开始===============");
        log.info("请求链接:{}", request.getRequestURL().toString());
        log.info("接口描述:{}", desc);
        log.info("请求类型:{}", request.getMethod());
        log.info("请求方法:{},{}", signature.getDeclaringTypeName(), signature.getName());
        log.info("请求ip:{}", request.getRemoteAddr());
        log.info("请求参数:{}", JSON.toJSONString(pjp.getArgs()));


        Object result = pjp.proceed();

        //请求结束时间挫
        long endTime = System.currentTimeMillis();

        log.info("请求耗时:{}", endTime - beginTime);

        log.info("请求返回:{}", JSON.toJSONString(result));

        log.info("================请求结束===============");

        return result;
    }

}
