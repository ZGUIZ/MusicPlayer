package com.zguiz.musicplayer.Annotation;

import com.zguiz.musicplayer.Test.IocDemo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class DealException {
    @AfterThrowing(pointcut="@annotation(TestExceptionAnnotation)",throwing="e")
    private static void dealException(JoinPoint joinPoint, Throwable e) throws ClassNotFoundException, NoSuchMethodException {
        String classType = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        Class<?>[] classes = new Class[args.length];
        classes[0] = IocDemo.class;
        ParameterNameDiscoverer pnd = new DefaultParameterNameDiscoverer();
        Method method = Class.forName(classType).getMethod(methodName,classes);
        // 参数名
        String[] parameterNames = pnd.getParameterNames(method);
        for (int i = 0; i < parameterNames.length; i++) {
            System.out.println("参数名："+parameterNames[i]+"\n参数值"+args[i]);
        }
    }
}
