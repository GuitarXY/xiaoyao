package com.host.annotation.t1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD})
public @interface Test {
    int min() default 0;
    int max() default 0;
    String description() default "";
}
