package com.demo.algorithms;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Demo class
 *
 * @author zhouj
 * @date 2018/10/31
 */
public class A0_SortCompare {
    public static void main(String[] args) {
        Map<String, String> nonParaMap = new HashMap<>();
//        nonParaMap.put("bubbleSort", "com.A1_BaseSort");
        nonParaMap.put("selectionSort", "com.A1_BaseSort");
        nonParaMap.put("insertionSort", "com.A1_BaseSort");
        nonParaMap.put("correctMethod", "com.A0_SortCompare");
        nonParaMap.put("shellSort", "com.A1_BaseSort");
        nonParaMap.put("shellSort2", "com.A1_BaseSort");

        Map<String, String> paraMap = new HashMap<>();
        paraMap.put("mergeSort", "com.A3_MergeSort");
        paraMap.put("qiuckSort", "com.A5_NetherLandsFlag_quickSort");
        paraMap.put("heapSort", "com.A6_HeapSort");

        int[] arr = A0_SortCompare.generateArrary(100, 200000);
        int L = 0;
        int R = arr.length - 1;

        for (Map.Entry<String, String> etry : nonParaMap.entrySet()) {
            int[] clone = arr.clone();
            countTimeCast(clone, etry.getValue(), etry.getKey());
        }

        for (Map.Entry<String, String> etry : paraMap.entrySet()) {
            int[] clone = arr.clone();
            if (etry.getKey().equals("heapSort")) {
                heapSortTimeCast(arr, etry.getValue(), etry.getKey());
            } else countTimeCastWithPara(clone, etry.getValue(), etry.getKey(), L, R);
        }

    }

    private static void countTimeCast(int[] arr, String classA, String sortMethod) {
        try {
            Class<?> clazz = Class.forName(classA);
            Object clazzObject = clazz.newInstance();
            Class objectClass = clazzObject.getClass();

            Method method = objectClass.getDeclaredMethod(sortMethod, int[].class);
            long millis = System.currentTimeMillis();
            method.invoke(clazzObject, arr);
            long millis2 = System.currentTimeMillis();
            System.out.println(method.getName() + " : " + (millis2 - millis));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void countTimeCastWithPara(int[] arr, String classA, String sortMethod, int L, int R) {
        try {
            Class<?> clazz = Class.forName(classA);
            Object clazzObject = clazz.newInstance();
            Class objectClass = clazzObject.getClass();

            Method method = objectClass.getDeclaredMethod(sortMethod, int[].class, int.class, int.class);
            long millis = System.currentTimeMillis();
            method.invoke(clazzObject, arr, L, R);
            long millis2 = System.currentTimeMillis();
            System.out.println(method.getName() + ":" + (millis2 - millis));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void heapSortTimeCast(int[] arr, String classA, String sortMethod) {
        try {
            Class<?> clazz = Class.forName(classA);
            Object clazzObject = clazz.newInstance();
            Class objectClass = clazzObject.getClass();

            Method method = objectClass.getDeclaredMethod(sortMethod, int[].class, int.class);
            Method heapInsert = objectClass.getDeclaredMethod("heapInsert", int[].class);
            long millis = System.currentTimeMillis();
            heapInsert.invoke(clazzObject, arr);
            method.invoke(clazzObject, arr, arr.length);
            long millis2 = System.currentTimeMillis();
            System.out.println(method.getName() + ":" + (millis2 - millis));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 产生一个元素值为0~value，长度为0~length的随机数组
     *
     * @param value  数组值
     * @param length 数组长度
     * @return
     */
    public static int[] generateRandomArray(int value, int length) {
        int len = (int) ((length + 1) * Math.random());/*0~length的随机整数*/
        return generateArrary(value, len);
    }

    /**
     * 产生一个元素值为0~value，长度为length的随机数组
     *
     * @param value
     * @param length
     * @return
     */
    public static int[] generateArrary(int value, int length) {
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((value + 1) * Math.random() - value * Math.random());
        }
        return arr;
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1)
                System.out.println("idx" + i + " : " + arr[i] + " ,");
            else
                System.out.print("idx" + i + " : " + arr[i] + " ,");
        }
    }

    /**
     * 交换数组元素位置
     *
     * @param i
     * @param j
     * @param arr
     * @return true
     */
    public static boolean swap(int i, int j, int[] arr) {
        int tep = arr[i];
        arr[i] = arr[j];
        arr[j] = tep;
        return true;
    }

    public static void correctMethod(int[] arr) {
        Arrays.sort(arr);
    }

    public static boolean isEqualArr(int[] arr1, int[] arr2) {
        if (arr1 == null) {
            return true;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
