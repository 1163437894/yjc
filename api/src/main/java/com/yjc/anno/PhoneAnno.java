package com.yjc.anno;


import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.*;

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
