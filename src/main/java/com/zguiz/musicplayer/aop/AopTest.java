package com.zguiz.musicplayer.aop;

import com.zguiz.musicplayer.service.UserService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopTest {

    public AopTest(){
    }
    @Pointcut("execution(* com.zguiz.musicplayer.service.impl.ClassifyServiceImpl.getClassify())")
    public void test(){

    }

    @Before("com.zguiz.musicplayer.aop.AopTest.test()")
    public void before(){
        System.out.println("test");

    }

}
