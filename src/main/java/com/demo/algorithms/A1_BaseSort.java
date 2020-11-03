package com.demo.algorithms;


public class A1_BaseSort extends A0_SortCompare{
    public static void main(String[] args) {
        /*对数器：
        1、产生随机数组
        2、对的排序方法
        3、大样本比较两排序结果是否一致*/
        int testTimes = 50000;
        boolean flag = true;
        for (int i = 0; i < testTimes; i++) {
            int[] randomArray = generateRandomArray(20, 100);
            int[] clone = randomArray.clone();
            int[] clone1 = randomArray.clone();
//            bubbleSort(randomArray);
//            selectionSort(randomArray);
//            insertionSort(randomArray);
            shellSort2(randomArray);
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

    /**
     * 冒泡排序：每一次循环比较找出范围内最大值
     * 稳定性：稳定
     * 缺点：与选择排序相比同为O(N*N)的排序，进行了太多次的元素交换操作
     * 时间复杂度O(N*N)
     * @param arr 数组
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2){
            return;
        }

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]){
                    swap(j,j+1,arr);
                }
            }
        }
    }

    /**
     * 选择排序：将数组最后一个元素与最大数交换位置
     * 稳定性：稳定
     * 优点：与冒泡排序相比少了交换元素的操作
     * 缺点：与选择排序相比，它一定要将两两比较进行到底，比较次数太多
     * 时间复杂度O(N*N)
     * @param arr
     */
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2){
            return;
        }

        for (int i = arr.length -1; i > 0; i--) {
            int maxIndex = i;
            for (int j = 0; j < i; j++) {
                maxIndex = arr[j] >= arr[maxIndex] ? j : maxIndex;
            }

            swap(i,maxIndex,arr);
        }
    }

    /**
     * 插入排序：从index = 1开始，每次加入一个数与前一个数去比较；大于等于前一个数break，
     *          否则小于前一个数就交换，一直到比较到数组第一个数或者break
     * 稳定性：稳定
     * 优点：与选择排序相比少了很多比较
     * 时间复杂度，最好O(N),最差O(N*N),这种按最差情况算，所以这也是O(N*N)的排序法
     * 在比较对象个数少于60个时采用插入排序，而不采用快排、归并等排序
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2){
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j-1]){
                    swap(j,j-1,arr);
                }else{
                    break;
                }
            }
        }
    }

    /**
     * shell排序：基于插入排序实现，按一定间隔(len)将一个数组看成len个数组,每个数组插入排序，直到len减小到1时，进行完全的插入排序
     * 例如12个元素的数组：
     * 1.将len定为4（12/4=3组），那么下标：0,4,8,为一组，1，5，9为一组，2，6，10为一组，3,7,11为一组进行插入排序
     * 2.再将len定位3,2直到1进行插入排序
     * @param arr
     */
    public static void shellSort(int[] arr) {
        if (arr == null || arr.length < 2){
            return;
        }
        int maxIndex = arr.length - 1;
        int h = 1;
        while (h < arr.length / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {//h:间隔数
            int startIdx = 0;
            while (startIdx < h) {
                int headIndx/*记录数组已比较的最后元素的index*/ = startIdx;
                int nextIdx/*记录数组未比较的第一个元素的index*/ = startIdx + h;
                while (nextIdx <= maxIndex) {
                    int tempHead = headIndx;
                    int tempNext = nextIdx;
                    while (tempHead >= 0) {
                        if (arr[tempNext] < arr[tempHead]) {
                            swap(tempHead, tempNext, arr);
                            tempNext = tempHead;
                            tempHead -= h;
                        } else {
                            break;
                        }
                    }
                    headIndx = nextIdx;
                    nextIdx += h;
                }
                startIdx++;
            }
            h = (h - 1) / 3;
        }
    }

    /**
     * Shell排序可以说是插入排序的升级版，相比较插入排序，
     * Shell排序首先使用大间隔、少元素的插入排序，使得每次移动的数据少，但是移动的跨度大；
     * 然后再使用小间隔，略多数量元素的插入排序，经过上一步插入排序，很多数据已经距离排序位置不远了，
     * 这样第二次插入排序时，需要移动的数据的数量就会减少，
     * 间隔最终减小到1.
     */
    public static void shellSort2(int[] input) {
        int length = input.length;
        int inner, outer;
        int temp;

        int h = 1;
        while (h <= length / 3) {
            h = h * 3 + 1;
        }

        while (h > 0) {
            for (outer = h; outer < length; outer++) {
                temp = input[outer];
                inner = outer;

                while (inner > h - 1 && input[inner - h] >= temp) {
                    input[inner] = input[inner - h];
                    inner -= h;
                }
                input[inner] = temp;
            }
            h = (h - 1) / 3;
        }

    }
}

