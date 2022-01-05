package com.example.lambdaa;

@FunctionalInterface
public interface Adder {

    int add(int n1, int n2, int n3);
}

class LamdaExample implements Adder{

    @Override
    public int add(int n1, int n2, int n3) {
        return 0;
    }
}
