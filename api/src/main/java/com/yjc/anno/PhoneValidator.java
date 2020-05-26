package com.yjc.anno;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 手机号验证规则
 *
 * @author yjc
 * @since 2020/5/26
 */
public class PhoneValidator implements ConstraintValidator<PhoneAnno, String> {
    @Override
    public void initialize(PhoneAnno constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return false;
        } else if (s.matches("^(13\\d|14[579]|15[^4\\D]|17[^49\\D]|18\\d)\\d{8}$")) {
            return true;
        } else {
            return false;
        }
    }
}
