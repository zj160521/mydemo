package com.demo.algorithms;

import java.util.EmptyStackException;

public class A11_ArrayStack {

    public static class ArrayStack {
        private static int[] arr;
        private static int index;

        public ArrayStack (int size) {
            if (size < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new int[size];
            index = 0;
        }

        public static void push (int num) {
            if (index == arr.length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            arr[index++] = num;
            System.out.println("peek:" + peek());
        }

        //弹出一个数后，index位置的数可以不置为0，下次push的时候会覆盖，这里我多了一部置为0的操作
        public static Integer pop () {
            if (index == 0) {
                throw new EmptyStackException();
            }
            int tmp = arr[--index];
            arr[index] = 0;
            return tmp;
        }

        public static Integer peek () {
            if (index - 1 >= 0) {
                return arr[index - 1];
            } else {
                throw new EmptyStackException();
            }
        }
    }

    public static void main(String[] args) {
        ArrayStack as = new ArrayStack(5);
        for (int i = 0; i < 3; i++) {
            as.push(i + 1);
            A0_SortCompare.printArr(as.arr);
        }
        for (int i = 0; i < 3; i++) {
            Integer pop = as.pop();
            System.out.println("弹出数：" + pop);
//            A0_SortCompare.printArr(arr);
        }
    }
}
