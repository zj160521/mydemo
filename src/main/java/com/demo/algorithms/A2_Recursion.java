package com.demo.algorithms;

/**
 * 递归函数实际就是系统栈的执行过程：
 * 代码执行到递归代码行，记录递归函数及其参数并压入系统栈，直至最底层函数
 * 从栈顶开始获取函数及其参数状态并执行，直至栈底，递归执行完毕
 *
 * 递归复杂度通式：T(N) = a*T(N/b) + O(N^d)
 * a:递归发生次数
 * b:每次递归数据的样本量
 * O(N^d):除递归外对数据操作的时间复杂度
 *
 * 满足上述通式的情况下：
 *  1、log(b,a) > d --> 时间复杂度：O(N^log(b,a))
 *  2、log(b,a) = d --> 时间复杂度：O(N^d*logN)
 *  3、log(b,a) < d --> 时间复杂度：O(N^d)
 *
 *  本例中递归次数为2，样本量为N/2,递归完之后的操作是比较两个数的大小，常数级操作，d为0
 *  log(b,a) = 1 大于 0
 *  所以本例中的时间复杂度为：O(N)
 */
public class A2_Recursion {
    private static int getMaxValue(int[] arr, int L, int R){
        if (L == R) {
            return arr[L];
        }

        int mid = (L + R)/2;
        int leftMax = getMaxValue(arr,L,mid);
        int rightMax = getMaxValue(arr, mid+1, R);
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        int[] arr = {3,1,5,8,9};
        int maxValue = getMaxValue(arr, 0, arr.length - 1);
        System.out.println(maxValue);
    }
}
