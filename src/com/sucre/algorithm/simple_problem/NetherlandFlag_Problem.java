package com.sucre.algorithm.simple_problem;

import java.util.Arrays;

public class NetherlandFlag_Problem {
    /**
     * 直接以right下标的数作为标准
     * @param target 目标数组
     * @param left 起点
     * @param right 终点
     * @return 相等区的边界
     */
    public static int[] netherlandFlag(int[] target, int left, int right){
        int less = left - 1;
        int more = right;
        int index = left;
        int num = target[right];
        while (index != more){
            if (target[index] < num){
                swap(target, index++, ++less);
            }else if (target[index] == num){
                index++;
            }else {
                swap(target, index, --more);
            }
        }
        swap(target, more, right);
        return new int[]{less+1,more};
    }
    public static void swap(int[] arr, int indexA, int indexB){
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {11,23,4351,12,3,21,342,12,32,45,356,23,23424,12,234,2,23,4,12};
        int[] res = netherlandFlag(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(arr));
    }
}
