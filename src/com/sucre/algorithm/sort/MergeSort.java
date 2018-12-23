package com.sucre.algorithm.sort;

import com.sucre.algorithm.utils.MergeUtils;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] target, int left, int right){
        if (target == null || left == right || target.length < 2) return;//只有一个数的数组直接表示有序
        int mid = left + ((right - left) >> 1);//涉及位运算的时候一定要加括号，否则就极易出错
        mergeSort(target, left, mid);//递归的把左边排好序
        mergeSort(target, mid + 1, right);//递归的把右边排好序
        MergeUtils.merge(target, left, mid, mid + 1, right);
    }

    public static void main(String[] args) {
        int[] arr = {2,131,12,34,21,34,4,23,56,2};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
