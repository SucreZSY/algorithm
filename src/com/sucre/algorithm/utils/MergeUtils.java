package com.sucre.algorithm.utils;

import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.util.Arrays;

public class MergeUtils {
    /**
     * 使用外排序将两个有序数组合并并返回的算法
     * @param left 左边有序数组
     * @param right 右边有序数组
     * @return 排序后的数组
     */
    public static int[] merge(int[] left, int[] right){
        if (left == null || left.length == 0) return  right;
        if (right == null || right.length == 0) return  left;//如果有一个为空就可以不用排序

        int indexL = 0;
        int indexR = 0;
        int indexI = 0;
        int[] arr = new int[left.length + right.length];
        while (indexL < left.length && indexR < right.length){
            if (left[indexL] <= right[indexR]){
                arr[indexI++] = left[indexL++];
            }else {
                arr[indexI++] = right[indexR++];//谁小谁出来，谁小谁的下标移动，添加=是为了排序的稳定性
            }
        }
        //把剩下的未比较的数复制进来
        while (indexL < left.length){
            arr[indexI++] = left[indexL++];
        }
        while (indexR < right.length){
            arr[indexI++] = right[indexR++];
        }
        return arr;
    }

    /**
     * 对一个数组中有序的两段进行排序
     * @param target 待排序大数组
     * @param indexLL 左边子数组的起始下标
     * @param indexLR 左子数组的终止下标
     * @param indexRL 右子数组的起始下标
     * @param indexRR 右子数组的终止下标
     */
    @SuppressWarnings("all")
    public static void merge(int[] target, int indexLL, int indexLR, int indexRL, int indexRR){
        if(indexLL == indexRL) return;//只有一个元素不需要排
        int indexL = indexLL;
        int indexR = indexRL;
        int indexI = 0;
        int[] arr = new int[(indexLR - indexLL + 1)+(indexRR - indexRL + 1)];

        while (indexL <= indexLR && indexR <= indexRR){
            if (target[indexL] <= target[indexR]) {
                arr[indexI++] = target[indexL++];
            }else {
                arr[indexI++] = target[indexR++];
            }
        }
        //将剩余的元素添加进来
        while (indexL <= indexLR){
            arr[indexI++] = target[indexL++];
        }
        while (indexR <= indexRR){
            arr[indexI++] = target[indexR++];
        }
        //将数组复制回去
        indexI = 0;
        while (indexLL <= indexLR){
            target[indexLL++] = arr[indexI++];
        }
        while (indexRL <= indexRR){
            target[indexRL++] = arr[indexI++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,45,67,345,400,1,45,223,456};
        merge(arr,0,4,5,8);

        System.out.println(Arrays.toString(arr));
    }
}
