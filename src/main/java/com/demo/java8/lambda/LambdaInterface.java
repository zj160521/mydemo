package com.demo.java8.lambda;

public interface LambdaInterface {
    void test();
    String test2();
}

@FunctionalInterface
interface LambdaInterface1 {
    void test(String str);
}