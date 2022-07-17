package com.demo.algorithms;


/**
 * 阻塞队列：使用非阻塞队列的时候有一个很大问题就是：它不会对当前线程产生阻塞，那么在面对类似消费者-生产者的模型时，
 * 就必须额外地实现同步策略以及线程间唤醒策略，这个实现起来就非常麻烦。但是有了阻塞队列就不一样了，它会对当前线程产生阻塞，
 * 比如一个线程从一个空的阻塞队列中取元素，此时线程会被阻塞直到阻塞队列中有了元素。当队列中有元素后，
 * 被阻塞的线程会自动被唤醒（不需要我们编写代码去唤醒）。这样提供了极大的方便性。
 */
public class A12_ArrayQueue {

    public static class ArrayQueue {
        private static int[] arr;
        private static int pushIndex;
        private static int pollIndex;
        private static int size;

        public ArrayQueue(int size) {
            if (size < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            arr = new int[size];
            this.pushIndex = 0;
            this.pollIndex = 0;
            this.size = 0;
        }

        public static Integer peek() {
            if (size == 0) throw new IllegalArgumentException("No element");
            if (pollIndex == arr.length) {
                pollIndex = 0;
            }
            return arr[pollIndex];
        }

        public static void push(int num) {
            if (size == arr.length) {
                throw new ArrayIndexOutOfBoundsException("The queue is full");
            }
            if (pushIndex == arr.length) {
                pushIndex = 0;
            }
            arr[pushIndex++] = num;
            size++;
            System.out.println("压入后size == " + size);
            A0_SortCompare.printArr(arr);
        }

        public static Integer poll() {
            if (size == 0) {
                throw new IllegalArgumentException("No element");
            }
            if (pollIndex == arr.length) {
                pollIndex = 0;
            }
            size--;
            System.out.println("弹出：" + arr[pollIndex]);
            System.out.println("弹出后size == " + size);
            return arr[pollIndex++];

        }
    }

    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue(5);
        for (int i = 0; i < 9; i++) {
            aq.push(i + 2);
            aq.peek();
            aq.poll();
        }
    }
}
