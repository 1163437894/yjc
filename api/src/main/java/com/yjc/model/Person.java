package com.yjc.model;

import lombok.Data;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource("classpath:config/person.properties")
public class Person {
    private String name;
    private String sex;
    private Integer age;
}
