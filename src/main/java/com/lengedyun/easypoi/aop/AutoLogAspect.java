package com.lengedyun.easypoi.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;


/**
 * 系统日志，切面处理类
 *
 * @Author scott
 * @email jeecgos@163.com
 * @Date 2018年1月14日
 */
@Aspect
@Component
public class AutoLogAspect {


    @Pointcut("@annotation(com.lengedyun.easypoi.aop.AutoLog)")
    public void logPointCut() {

    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //执行方法
        Object result = joinPoint.proceed();
        getann(joinPoint);
        return result;
    }

    private void getann(ProceedingJoinPoint joinPoint){

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        AutoLog annotation = method.getAnnotation(AutoLog.class);
//        AutoLog annotation = method.getDeclaredAnnotation(AutoLog.class);
        System.out.println(annotation.businessType().getBusinessType());
        System.out.println(annotation.value());
        System.out.println(annotation.operateType().getOperateType());
    }


}
