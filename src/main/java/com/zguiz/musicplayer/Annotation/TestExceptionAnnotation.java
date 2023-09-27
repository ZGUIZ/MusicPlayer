package com.zguiz.musicplayer.Annotation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TestExceptionAnnotation {
}
