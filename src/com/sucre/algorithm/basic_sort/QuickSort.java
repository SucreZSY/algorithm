package com.sucre.algorithm.basic_sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static Random random = new Random();
    public static void quickSort(int[] target){ quickSort(target, 0, target.length - 1);}

    public static void quickSort(int[] target, int left, int right){
        if (target == null || target.length < 2 || left >= right){//递归出口
            return;
        }
        //随机快排，随机选取一个数交换到right位置
        int index = left + random.nextInt(right - left + 1);//注意随机数起点一定要是left
        swap(target, index, right);

        int[] res = partition(target, left, right);

        quickSort(target, left, res[0] - 1);
        quickSort(target, res[1] + 1, right);
    }

    /**
     * 为了加深coding的理解和细节能力，这里把partition过程重新写一遍
     * @param target 目标数组
     * @param left 左边界
     * @param right 右边界
     * @return 相等区间的边界
     */
    @SuppressWarnings("all")
    public static int[] partition(int[] target, int left, int right){
        int less = left - 1;
        int more = right + 1;//这里为啥要加1? 一样的，把交换提前了而已
        int index = left;
        int num = target[right];

        while (index != more){//很容易写错，认真思考，其实index是一直在右移的，所以一定会和right相遇是index，left永远不会和right相遇
            if (target[index] < num){//这个数应该要进入less区，而且走到这说明，这个数和less中间只要有值应该都是等于num的
                swap(target, index++, ++less);
            }else if (target[index] == num){
                index++;
            }else {
                swap(target, index, --more);
            }
        }
        return new int[]{less + 1, more - 1};
    }

    public static void swap(int[] arr, int indexA, int indexB){
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {-3,2,3,11,23,4351,12,3,21,342,12,32,23,356,23,23424,12,234,2,23,4,12,324,12,12,12,3,5,7};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
