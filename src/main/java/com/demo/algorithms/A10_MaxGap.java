package com.demo.algorithms;

import java.util.Arrays;

/**
 * 利用桶原理求数组中两个相邻值的最大差值
 */
public class A10_MaxGap {
    public static void main(String[] args) {
        boolean flag = true;
        for (int i = 0; i < 100000; i++) {
            int[] ints = A0_SortCompare.generateRandomArray(20, 10);
            int[] clone = ints.clone();
            Integer integer = correctMethod(clone);
            Integer integer1 = maxGap(ints);
            if (integer != integer1) {
                flag = false;
            }
        }
        System.out.println(flag);
//        int[] arr = {5,3,10,9,8};
//        Integer integer = maxGap(arr);
//        Integer integer = correctMethod(arr);
//        System.out.println(integer);
    }

    public static Integer maxGap(int[] arr) {
        if (arr == null || arr.length <= 1) return 0;
        int len = arr.length;
        Integer min = null;
        Integer max = null;
        for (int i = 0; i < len; i++) {
            if (min == null && max == null) {
                min = max = arr[i];
            } else {
                min = Integer.min(arr[i], min);
                max = Integer.max(arr[i], max);
            }

        }
        if (min == max) return 0;
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        boolean[] hasNum = new boolean[len + 1];
        //每个桶的最大最小值填充
        for (int i = 0; i < len; i++) {
            int num = arr[i];
            int bucket = bucket(min, max, len, num); //num属于哪个桶
            maxs[bucket] = hasNum[bucket] == false ? num : Math.max(maxs[bucket], num);
            mins[bucket] = hasNum[bucket] == false ? num : Math.min(mins[bucket], num);
            hasNum[bucket] = true;
        }

        Integer preMax = null;
        int count = 0;
        for (int i = 0; i < hasNum.length; i++) {
            boolean has = hasNum[i];
            if (has) {
                if (preMax == null) {
                    preMax = maxs[i];
                } else {
                    count = Math.max(count, mins[i] - preMax);
                    preMax = maxs[i];
                }
            }
        }
        return count;
    }

    //求num属于哪个桶
    public static int bucket(int min, int max, int len, int num) {
        return ((num - min) * (len + 1) / (max - min + 1));
    }

    public static Integer correctMethod(int[] arr) {
        if (arr == null || arr.length <= 1) return 0;
        Arrays.sort(arr);
        Integer pre = arr[0];
        int difference = 0;
        for (int i = 1; i < arr.length; i++) {
            difference = arr[i] - pre > difference ? arr[i] - pre : difference;
            pre = arr[i];
        }
        return difference;
    }
}
