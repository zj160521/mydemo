package com.demo.algorithms;

/**
 * 归并排序：采用递归将数据分成树状结构数据，从最底层数据开始逐级对根节点进行排序，采用了中间变量数组arrTemp来存放每次比较好的顺序元素
 * 稳定性：稳定
 * a=2,b=2,d=1 , log(b,a) = d
 * 所以时间复杂度O(N)*logN
 */
public class A3_MergeSort extends A0_SortCompare {
    public static void main(String[] args) {
//        int[] arr = generateArrary(100, 1000);
//        long millis = System.currentTimeMillis();
//        mergeSort(arr, 0, arr.length-1);
//        long millis2 = System.currentTimeMillis();
//        System.out.println("timeCast : "+ (millis2 - millis));
//        A0_SortCompare.printArr(arr);
        checkMethod(5000, 100, 2);
    }

    public static void mergeSort(int[] arr, int L, int R) {
        if (arr == null || arr.length < 2)
            return;
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);//等价于(R+L)/2
        mergeSort(arr, L, mid);
        mergeSort(arr, mid + 1, R);
        merge(arr, L, R, mid);//O(N)
    }

    public static void merge(int[] arr, int L, int R, int mid) {
        int[] arrTemp = new int[R - L + 1];
        int i = 0;
        int leftStartIdx = L;
        int rightStartIdx = mid + 1;
        //直至一个idx越界停止，数组越界侧数值已全部填进arrtemp
        while (leftStartIdx <= mid && rightStartIdx <= R) {
            arrTemp[i++] = arr[leftStartIdx] <= arr[rightStartIdx] ? arr[leftStartIdx++] : arr[rightStartIdx++];
        }
        //下面两个while将数组未越界侧未填进arrtemp的数值填进去
        while (leftStartIdx <= mid)
            arrTemp[i++] = arr[leftStartIdx++];
        while (rightStartIdx <= R)
            arrTemp[i++] = arr[rightStartIdx++];

        for (int j = 0; j < arrTemp.length; j++) {
            arr[L + j] = arrTemp[j];
        }
    }

    private static void checkMethod(int testTimes, int value, int arrLength) {
        boolean flag = true;
        for (int i = 0; i < testTimes; i++) {
            int[] randomArray = generateRandomArray(value, arrLength);
            int[] clone = randomArray.clone();
            int[] clone1 = randomArray.clone();
            int L = 0;
            int R = randomArray.length - 1;
            mergeSort(randomArray, L, R);
            correctMethod(clone);
            boolean equals = isEqualArr(randomArray, clone);
            if (!equals) {
                flag = false;
                printArr(clone1);
                break;
            }
        }
        System.out.println(flag ? "succeed" : "false");
    }
}
