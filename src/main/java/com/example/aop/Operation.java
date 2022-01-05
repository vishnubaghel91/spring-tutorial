package com.example.aop;

import org.springframework.stereotype.Component;

@Component
public class Operation {

    public void m1() {
        System.out.println("m1 method");
        throw new ArithmeticException();
    }

    public void m2() {
        System.out.println("m2 method");
    }

    public int m3() {
        System.out.println("m3 method");
        return 2;
    }
    public void k(){
        System.out.println("k method");
    }
}
