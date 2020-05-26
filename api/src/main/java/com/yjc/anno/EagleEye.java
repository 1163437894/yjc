package com.yjc.anno;

import java.lang.annotation.*;


/**
 * 请求切入
 *
 * @author yjc
 * @since 2020/5/26
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EagleEye {

    /**
     * 接口描述
     *
     * @return
     */
    String desc() default "访问接口";
}
