package com.demo.Algorithms;

import java.util.Stack;

/**
 * 利用栈实现队列：用两个栈，一个push元素，一个pop元素
 */
public class A15_stackQueue {
    private static Stack stackIn;
    private static Stack stackOut;

    public A15_stackQueue() {
        stackIn = new Stack();
        stackOut = new Stack();
    }

    public static void push(int num) {
        stackIn.push(num);
    }

    public static Integer pop() {
        if (true){}
        while (!stackIn.isEmpty()) {
            Integer pop = (int)stackIn.pop();
            stackOut.push(pop);
        }
        return null;
    }
}
