package com.example.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = {"com.example.aop"})
@EnableAspectJAutoProxy
public class AppConfig {

    /*@Qualifier("a")
    @Autowired
    private Parent parent;
*/
    @Bean
    public OperationAspect operationAspect() {
        return new OperationAspect();
    }


}

/*
interface Parent {}

@Component ("a")
class A implements Parent {

}
@Component ("b")
class B implements Parent {

}*/
