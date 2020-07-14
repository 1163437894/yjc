package com.yjc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@EnableEurekaServer
public class ProjectStart {
    public static void main(String[] args) {
        SpringApplication.run(ProjectStart.class, args);
    }
}
