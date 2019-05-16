package com.sucre.algorithm.basic_sort;


import java.util.Arrays;

public class HeapSort {
    /**
     * 主要过程：建堆，然后循环的把堆顶和堆底--交换，然后重新调整堆
     * @param target 目标数组
     */
    public static void heapSort(int[] target){
        if (target == null || target.length < 2) return;
        int index;
        for (index = 1; index < target.length; index++){
            heapInseart(target, index);
        }
        //将第一位交换到最后，然后把调整的右边界减小1
        index = 0;//定位堆顶
        for (int size = target.length - 1; size > 0;){
            swap(target, index, size--);
            heapify(target, size);
        }
    }
    /**
     * 把一个元素插到堆底并调整的过程
     * @param target 目标数组
     * @param index 堆底元素下标
     */
    public static void heapInseart(int[] target, int index){
        int parent = index == 0 ? 0 : ((index - 1) >> 1);//防止index是0的情况下parent变成了负数
        while (target[index] > target[parent]){
            swap(target, index, parent);
            index = parent;
            parent = index == 0 ? 0 : ((index - 1) >> 1);//防止此时index是0的情况下parent变成负数
        }                                               //当然，也可以直接把判断条件放在while中
    }

    /**
     * 调整堆顶
     * @param target 目标数组
     * @param size 堆底元素下标
     */
    public static void heapify(int[] target, int size){
        int index = 0;
        int left = (index << 1) + 1;
        int right = (index << 1) + 2;
        int max;//代表左右子节点中大的那个的下标

        while (left <= size){
            max = (right > size || target[right] < target[left]) ? left : right;
            if (target[index] >= target[max]) return;
            swap(target, index, max);
            index = max;
            left = (index << 1) + 1;
            right = (index << 1) + 2;
        }
    }

    public static void swap(int[] arr, int indexA, int indexB){
       int temp = arr[indexA];
       arr[indexA] = arr[indexB];
       arr[indexB] = temp;
    }
    public static void main(String[] args){
        int[] arr = {1,1,1,1,5,6,76,2,8,81,23,12,345,211,213,124,1321};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
