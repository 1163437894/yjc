package com.yjc.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Lock {

    /**
     * 锁key
     *
     * @return
     */
    String key();


    /**
     * 加锁时间
     *
     * @return
     */
    long expire();


}
