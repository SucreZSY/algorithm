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

    /**
     * 找到数组中最大和最小的数
     * @param arr 目标数组
     * @return 返回最大数和最小数的数组，坐标0为最大，坐标1为最小
     */

    public static int[] findEndpoints(int[] arr){
        int max = arr[0];
        int min = max;
        for (int i : arr) {
            max = max < i ? i : max;
            min = min > i ? i : min;
        }
        return new int[]{max, min};
    }
}
