package com.yy.web.listener.annotation;

import com.yy.web.listener.enums.EventEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ListenerAnnotation {

    long millis() default 3000;

    EventEnum value();

}
