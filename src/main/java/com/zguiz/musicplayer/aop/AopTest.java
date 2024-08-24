package com.zguiz.musicplayer.aop;

import com.zguiz.musicplayer.service.UserService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.mybatis.spring.annotation.MapperScannerRegistrar;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

@Aspect
@Component
public class AopTest {

    public AopTest(){
    }
    @Pointcut("execution(* com.zguiz.musicplayer.service.impl.ClassifyServiceImpl.getClassify())")
    public void test(){
        System.out.println("test1");
    }

    @Before("com.zguiz.musicplayer.aop.AopTest.test()")
    public void before(){
        System.out.println("test");
    }

}
