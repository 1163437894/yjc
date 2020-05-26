package com.yjc.anno;

import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorDescriptor;
import org.springframework.beans.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidatorFactory;
import javax.validation.constraintvalidation.ValidationTarget;
import java.lang.reflect.Type;
import java.util.EnumSet;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch,Object> {


    private String firstName;
    private String secondName;

    @Override
    public void initialize(FieldMatch constraintAnnotation) {
        firstName=constraintAnnotation.first();
        secondName=constraintAnnotation.second();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        BeanUtils.copyProperties(o,firstName);
        BeanUtils.copyProperties(o,secondName);
        return firstName == null && secondName == null || firstName != null && firstName.equals(secondName);
    }
}
