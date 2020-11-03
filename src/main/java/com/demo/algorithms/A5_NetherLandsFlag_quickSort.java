package com.demo.algorithms;

/**
 * 经典快排：一个数组将小于等于最后一个元素数的放左边，比这个数大的元素放数组右边（每次只解决了最后那一个数的位置）
 * 荷兰国旗问题：一个数组将小于某个数的元素放左边，比这个数大的元素放数组右边，等于这个数的放中间
 * 快速排序：利用荷兰国旗的思路，递归将数组最后一个数作为指定数进行排序，相比于经典快排，若等于指定数的数有多个，就多确定了几个数的位置
 * 稳定性：不稳定
 */
public class A5_NetherLandsFlag_quickSort extends A0_SortCompare{

    public static void main(String[] args) {
//        long millis = System.currentTimeMillis();
////        int[] arr = A0_SortCompare.generateArrary(100, 100000);
//        int[] arr = {20,19,10};
//        int L = 0;
//        int R = arr.length -1;
//        qiuckSort(arr, L, R);
//        long millis2 = System.currentTimeMillis();
//        System.out.println(millis2 - millis);
//        A0_SortCompare.printArr(arr);
        checkMethod(200000, 20, 10);
    }

    /**
     * 快速排序 quickSort
     * @param arr 目标数组
     * @param L 数组左边界index
     * @param R 数组右边界index
     */
    public static void qiuckSort(int[] arr , int L, int R){
        if (arr == null || arr.length < 2 || L >= R || R <= 0){
            return;/*递归出口L >= R 或者 R<=0*/
        }

//        swap(arr, (int)(L+(R-L+1)*Math.random()), R);/*加上这句就是随机快排*/
        int num = arr[R];
        int lessIdx = L;
        int biggerIdx = R;
//        for (int i = L; i <= R; i++) {
//            if (i > biggerIdx) break;
//            if (arr[i] == num) continue;
//            boolean flag = arr[i] > num ? swap(arr, i--, biggerIdx--) : swap(arr, i, lessIdx++);
//        }

        int i = L;
        while (i <= biggerIdx) {
            if (arr[i] > num) {
                swap(i, biggerIdx--, arr);
            } else if (arr[i] < num) {
                swap(i++, lessIdx++, arr);
            } else {
                i++;
            }
        }

        qiuckSort(arr, L, lessIdx - 1);/*左边小于num的数组递归*/
        qiuckSort(arr, biggerIdx+1, R);/*右边大于num的数组递归*/
    }



    private static void checkMethod(int testTimes, int value, int arrLength){
        boolean flag = true;
        for (int i = 0; i < testTimes; i++) {
            int[] randomArray = generateRandomArray(value, arrLength);
            int[] clone = randomArray.clone();
            int[] clone1 = randomArray.clone();
            int L = 0;
            int R = randomArray.length -1;
            qiuckSort(randomArray, L, R);
            correctMethod(clone);
            boolean equals = isEqualArr(randomArray,clone);
            if (!equals){
                flag = false;
                printArr(clone1);
                break;
            }
        }
        System.out.println(flag ? "succeed" : "false");
    }
}
