package com.demo.Algorithms;

/**
 * 如果流持续向你发送数据，求当时的中位数(中位数：奇数个取中间那个，偶数个去中间两个的平均值)
 * 把流持续分为两个数组：一个大根堆，一个小根堆
 */
public class A7_Median {
    public static void main(String[] args) {
        int[] arr = {5,2};
        getMedian(arr);
    }

    public static void getMedian (int[] arr) {
        if (arr == null || arr.length == 0) return;
        if (arr.length == 1) {
            System.out.println(arr[0]);
            return;
        }
        if (arr.length == 2) {
            System.out.println((arr[0] + arr[1])/2);
            return;
        }
        int[] bigHeap = new int[arr.length/2 + 1];
        int[] littleHeap = new int[arr.length/2 + 1];
        int bigIndex = 0;
        int littleIndex = 0;
        for(int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (bigIndex == 0 && littleIndex == 0) {
                bigHeap[bigIndex++] = num;
            } else {
                if (bigIndex <= littleIndex) {
                    if (num <= bigHeap[0]) {
                        bigHeap[bigIndex] = num;
                        A0_SortCompare.swap(0, bigIndex++, bigHeap);
                        A6_HeapSort.heapify(arr, 0, bigIndex);
                    } else {
                        littleHeap[littleIndex] = num;
                        A0_SortCompare.swap(0, littleIndex++, littleHeap);
                        A6_HeapSort.heapify(arr, 0, littleIndex);
                    }
                }
            }

        }
    }
}
