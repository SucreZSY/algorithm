package com.sucre.algorithm.sort;

import java.util.Arrays;

public class BubbleSort {
    /**
     * 冒泡排序
     * @param target 待排序数组
     */
    public static void bubbleSort(int[] target){
        if (target == null || target.length < 2) return;
        int j;
        for (int i = 0; i < target.length; i++){
            for (j = 1; j < target.length - i; j++){
                if (target[j] < target[j-1]){
                    swap(target,j,j-1);
                }
            }
        }
    }
    public static void swap(int[] arr, int indexA, int indexB){
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2,34,534,12,456,67,8,32,12};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
