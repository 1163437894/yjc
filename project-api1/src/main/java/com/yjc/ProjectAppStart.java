package com.yjc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@EnableEurekaClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ProjectAppStart {
    public static void main(String[] args) {
        SpringApplication.run(ProjectAppStart.class, args);
    }
}
