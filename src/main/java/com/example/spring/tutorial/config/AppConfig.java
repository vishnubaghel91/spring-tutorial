package com.example.spring.tutorial.config;

import com.example.spring.tutorial.aop.EmployeeServiceAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public EmployeeServiceAspect employeeServiceAspect() {
        return new EmployeeServiceAspect();
    }


}


