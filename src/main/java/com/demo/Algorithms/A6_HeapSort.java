package com.demo.Algorithms;

public class A6_HeapSort extends A0_SortCompare{
    /**
     * 完全二叉树：最后一个叶节点前面没有空的叶节点
     * 满二叉树：除了叶结点外每一个结点都有左右子叶且叶子结点都处在最底层的二叉树。
     * 大根堆：父节点始终比子节点大
     * 小根堆：父节点始终比子节点小
     * 大小根堆都可以作为堆排序的算法
     * 这里是利用大根堆，过程：1.将
     */
    public static void main(String[] args) {
//        int[] arr = new int[]{5,6,1,3};
//        heapInsert(arr);/*构建大根堆*/
//        A0_SortCompare.printArr(arr);
//        heapSort(arr, arr.length);
//
//        System.out.println("*********");
//        printArr(arr);
        checkMethod(1000, 10, 10);

    }

    public static void heapSort(int[] arr, int heapSize){
        if (arr == null || arr.length < 2) return;
        heapInsert(arr);
        while (heapSize > 0) {
            swap(0, --heapSize, arr);
            heapify(arr, 0, heapSize);
        }
    }

    /**
     *将数组变成大根堆数组
     * @param arr 元数组
     */
    public static void heapInsert(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            compareWithFatherNode(arr, i);
        }
    }

    public static void compareWithFatherNode(int[] arr, int index){
        int parentIdx = (index-1) / 2;
        while (arr[index] > arr[parentIdx]) {
            swap(index, parentIdx, arr);
            index = parentIdx;
            parentIdx = (index-1) / 2;
        }
    }

    /**
     * 大根堆数组某个元素发生变化，使数组再度成为大根堆
     * @param arr 数组
     * @param index 元素发生变化的位置
     * @param heapSize 数组长度
     */
    public static void heapify(int[] arr, int index, int heapSize){
        if (arr == null || arr.length == 0) return;
        heapSize--;/*将size边界转化为index边界*/
        while (heapSize >= index*2+2|| heapSize >= index*2+1){
            int left = index * 2 + 1;
            int right = left + 1;
            int bigerIndex;
            //判断左右子节点谁大，首先判断是否存在右节点
            bigerIndex = heapSize/*arr的idx边界值*/ >= right ? arr[left] > arr[right] ? left : right : left;
            if (arr[bigerIndex] > arr[index]){
                swap(index, bigerIndex, arr);
                index = bigerIndex;
            } else break;

        }
    }

    private static void checkMethod(int testTimes, int value, int arrLength){
        boolean flag = true;
        for (int i = 0; i < testTimes; i++) {
            int[] randomArray = generateRandomArray(value, arrLength);
            int[] clone = randomArray.clone();
            int[] clone1 = randomArray.clone();
            heapSort(randomArray, randomArray.length);
            correctMethod(clone);
            boolean equals = isEqualArr(randomArray,clone);
            if (!equals){
                flag = false;
                printArr(randomArray);
                System.out.println("----------");
                printArr(clone1);
                break;
            }
        }
        System.out.println(flag ? "succeed" : "false");
    }
}
