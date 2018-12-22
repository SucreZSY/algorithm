package com.sucre.algorithm.sort;

import java.util.Arrays;

public class SelectSort {
    /**
     * 选择排序算法
     * @param target 目标数组
     */
    public static void selectSort(int[] target){
        int min;//定义最小值下标
        int j;
        for(int i = 0; i < target.length - 1; i++){
            min = i;
            for (j = i; j < target.length; j++){
                min = target[min] < target[j] ? min : j;
            }
            swap(target,min,i);
        }
    }

    public static void swap(int[] arr, int indexA, int indexB){
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;

    }

    public static void main(String[] args) {
        int[] arr = {21,241,53,21,21,53,1,24,35,632,11,4,2};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
