package com.zguiz.musicplayer.Test;

import com.zguiz.musicplayer.Annotation.TestExceptionAnnotation;
import org.springframework.stereotype.Component;

@Component
public class AopDemo1 {
    @TestExceptionAnnotation
    public void test1(IocDemo demo){
        System.out.println("Test Demo 1");
    }

    @TestExceptionAnnotation
    public void test2(IocDemo demo){
        System.out.println("Test Demo 1");
            if(demo != null){
            throw new RuntimeException("Test Exception");
        }
    }
}
