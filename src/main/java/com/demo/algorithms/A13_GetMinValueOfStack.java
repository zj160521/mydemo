package com.demo.algorithms;

import java.util.Stack;

public class A13_GetMinValueOfStack {

    public static class MinStack {
        private static Stack<Integer> stack;
        private static Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack();
            minStack = new Stack();
        }

        public static void push(int value) {
            stack.push(value);
            if (minStack.isEmpty()) {
                minStack.push(value);
            } else {
                int minValue = minStack.peek() <= value ? minStack.peek() : value;
                minStack.push(minValue);
            }
        }

        public static void pop() {
            stack.pop();
            minStack.pop();
        }

        public static Integer peek() {
            return stack.peek();
        }

        public static Integer getMin() {
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 8, 6, 1};
        MinStack ms = new MinStack();
        for (int i = 0; i < arr.length; i++) {
            ms.push(arr[i]);
            System.out.println(ms.peek() + "===" + ms.getMin());
        }
    }
}
