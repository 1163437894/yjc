package com.yjc.test;

import com.yjc.anno.FieldMatch;
import com.yjc.anno.PhoneAnno;
import com.yjc.anno.PhoneValidator;
import com.yjc.anno.TestAnno;

import javax.validation.constraints.NotBlank;
import java.lang.reflect.Method;

public class TestAnnoController {

    public static void main(String[] args) {

//        test1();
        test2();
    }

    @TestAnno("hello world")
    @NotBlank
    public static void test1(){
        //获取class类
        Class<TestAnnoController> aClass = TestAnnoController.class;
        try {
            //获取类方法
            Method method = aClass.getMethod("test1");
            //获取注解
            TestAnno testAnno = method.getAnnotation(TestAnno.class);
            //输出注解value
            System.out.println(testAnno.value());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @PhoneAnno
    private static String name="123";

    public static void test2(){
        System.out.println(name);
    }


}
