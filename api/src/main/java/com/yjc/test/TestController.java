package com.yjc.test;

import com.yjc.anno.EagleEye;
import com.yjc.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/test")
public class TestController {

    @Value("${person.name}")
    private String name;
    @Value("${person.sex}")
    private String sex;
    @Value("${person.age}")
    private Integer age;

    @Autowired
    private ApplicationContext applicationContext;


    @RequestMapping("demo")
    public String demo() {
        System.out.println(name);
        System.out.println(sex);
        System.out.println(age);

        boolean myService = applicationContext.containsBean("myService");
        System.out.println(myService);
        return "demo";
    }


    @RequestMapping("/test")
    public String test() {
        return "nacos";
    }

    public static void main(String[] args) {
        ClassLoader loader = TestController.class.getClassLoader();
        try {

            Class<?> appStart = loader.loadClass("");
            System.out.println(appStart);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(loader);
        ClassLoader parent = loader.getParent();
        System.out.println(parent);
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);
    }


    @GetMapping("testValidator")
    public String testValidator(@Valid Test test) {
        return "?";
    }


    @GetMapping("testAop")
    @EagleEye(desc = "测试切入")
    public String testValidator(@RequestParam String name) {
        return name;
    }


}
