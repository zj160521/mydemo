package com.demo.exception;

public class TryTest {

    public static void main(String[] args) {
        // 没有return，try先执行，finally后执行
        // try中有return，在return执行前进入finally，不影响try中任何计算逻辑
        // finally中有return，会提前返回
        System.out.println(test());
        System.out.println(test2());
        test3();
    }

    private static Integer test() {
        int a = 1;
        try {
            return a + 1;
        } finally {
            a = 2;
        }
    }

    private static Integer test2() {
        int a = 1;
        try {
            return a + 1;
        } finally {
            a = 3;
            return a;
        }
    }

    private static void test3() {
        int a = 1;
        try {
            System.out.println(a);
        } finally {
            System.out.println(a + 1);
        }
    }
}
