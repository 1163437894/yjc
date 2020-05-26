package com.yjc.anno;


import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.*;

/**
 * 手机号验证注解
 *
 * @author yjc
 * @since 2020/5/26
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PhoneValidator.class})
@NotNull
@Documented
public @interface PhoneAnno {

    String message() default "手机号格式错误"; //错误提示信息

    Class<?>[] groups() default {}; //分组


    Class<? extends Payload>[] payload() default {}; //不知道

}
