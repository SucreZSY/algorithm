package com.sucre.algorithm.sort;

import java.util.Arrays;

public class InsertSort {
    /**
     * 插入排序算法
     * @param target 目标数组
     */
    public static void insertSort(int[] target){
        int j;
        for (int i = 1; i < target.length; i++){
            for (j = i; j > 0; j--){
                if (target[j] >= target[j-1]){
                    break;
                }
                swap(target, j, j-1);
            }
        }
    }

    public static void swap(int[] arr, int indexA, int indexB){
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,231,142,3,34,124,512,132,4,6,3};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
