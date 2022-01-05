package com.example.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Operation operation = context.getBean(Operation.class);

        //Parent parent  = context.getBean("a", Parent.class);
        try {
            operation.m3();

        } catch (Exception e) {
            System.out.println("calling m1 again after throwing");
        }
    }
}
