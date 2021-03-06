package com.iphone567.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 注解有效期
@Target({ElementType.TYPE, ElementType.METHOD}) // 该注解能修饰哪些元素
public @interface MyTest {
	long timeout() default 0;
}
