package com.sucre.algorithm.utils;

public class ArrayUtils {
    /**
     * 交换数组元素
     * @param arr 目标数组
     * @param indexA 交换元素下标1
     * @param indexB 交换元素下标2
     */
    public static void swap(int[] arr, int indexA, int indexB){
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }
}
