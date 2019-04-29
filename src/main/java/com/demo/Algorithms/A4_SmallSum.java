package com.demo.Algorithms;

/**
 * 小和：一个数组中每一个数左边比当前数小的数的总和
 * 逆序对：数组中左边的元素比右边大，那这两个数就构成了逆序对（这两个数不一定相邻）
 */
public class A4_SmallSum {

    static int count = 0;
    public static void main(String[] args) {
        int testTimes = 20;
        boolean flag = true;
        for (int i = 0; i < testTimes; i++) {
            count = 0;
            int[] randomArray = A0_SortCompare.generateRandomArray(10, 8);
            int[] clone = randomArray.clone();
            int[] clone1 = randomArray.clone();
            countProcess(randomArray, 0, randomArray.length-1);
            int cnt = correctMethod(clone);
            if (cnt != count){
                flag = false;
                A0_SortCompare.printArr(clone1);
                break;
            }
//            System.out.println(count+" : "+cnt);
        }
        System.out.println(flag ? "succeed" : "false");
    }

    /*逆序对*/
//    public static void main(String[] args) {
//        int[] randomArray = {5,1,3,2};
//        countProcess(randomArray, 0, randomArray.length-1);
//        System.out.println(count);
//    }

    public static void countProcess(int[] arr, int L, int R){
        if(arr == null || arr.length < 2)
            return;
        if(L == R){
            return;
        }
        int mid = L + ((R - L) >> 1);//等价于(R+L)/2
        countProcess(arr, L, mid);
        countProcess(arr, mid+1, R);
        merge(arr, L, R, mid);//O(N)
    }

    public static void merge(int[] arr, int L, int R, int mid){
        int[] arrTemp = new int[R-L+1];
        int i = 0;
        int leftIdx = L;
        int rightIdx = mid + 1;
        //直至一个idx越界停止，数组越界侧数值已全部填进arrtemp
        while(leftIdx <= mid && rightIdx <= R) {
            //小和
            count += arr[leftIdx] < arr[rightIdx] ? (R-rightIdx+1) * arr[leftIdx] : 0;
            //逆序对
//            count += arr[leftIdx] > arr[rightIdx]?(mid - leftIdx + 1) : 0;
            arrTemp[i++] = arr[leftIdx] < arr[rightIdx] ? arr[leftIdx++] : arr[rightIdx++];
        }
        //下面两个while将数组未越界侧未填进arrtemp的数值填进去
        while(leftIdx <= mid)
            arrTemp[i++] = arr[leftIdx++];
        while(rightIdx <= R)
            arrTemp[i++] = arr[rightIdx++];

        for (int j = 0; j < arrTemp.length; j++) {
            arr[L+j] = arrTemp[j];
        }
    }

    private static int correctMethod(int[] arr){
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    count += arr[j];
                }
            }
        }
        return count;
    }
}
