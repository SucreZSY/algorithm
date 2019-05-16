package com.sucre.algorithm.sort_problem;

import java.util.Arrays;

public class SimplePartition_Problem {
    /**
     * 把数组中所有小于等于num的数放到数组左边，大于的放到右边
     * @param target 目标数组
     * @param num 目标数值
     */
    public static void simplePartition(int[] target, int num){
        int less = -1;
        for (int index = 0; index < target.length; index++){
            if (target[index] <= num) swap(target, index, ++less);
        }
    }
    public static void swap(int[] arr, int indexA, int indexB){
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {11,23,4351,12,3,21,342,12,32,45,356,23,23424,12,234,2,23,4,2};
        simplePartition(arr, 24);
        System.out.println(Arrays.toString(arr));
    }
}
