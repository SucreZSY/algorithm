package com.sucre.swordoffer;

import java.util.Arrays;

/**
 * 实现稳定的给数组中奇偶数分组的方法，保证奇偶数各自的相对稳定性
 */
public class ReOrderArray {
    /**
     * 给数组分组，使左边都是奇数右边都是偶数，但要保证相对稳定性（partition直接不行，考虑归并）
     * @param array 目标数组
     */
    public void reOrderArray(int[] array) {
        if (array == null || array.length <= 1) return;
        reOrderArray(array, 0, array.length - 1);
    }

    /**
     * 使用归并排序来给数组分组
     * @param arr 目标数组
     * @param left 左边界
     * @param right 右边界
     */
    public void reOrderArray(int[] arr, int left, int right){
        if (left >= right) return ;
        //让左边和右边分别分好组，然后归并即可
        int mid = left + ((right - left) >> 1);
        reOrderArray(arr, left, mid);
        reOrderArray(arr, mid + 1, right);
        merge(arr, left, mid, mid + 1, right);
    }

    /**
     * 归并两边已分组数组的方法
     * @param arr 目标数组
     * @param ll 左边的左边界
     * @param lr 左边的右边界
     * @param rl 右边的左边界
     * @param rr 右边的右边界
     */
    public void merge(int[] arr, int ll, int lr, int rl, int rr){
        if (lr >= rl) return ;
        int begin = ll;
        //使用两个数组和两个指针别记录奇数和偶数
        Integer[] odds = new Integer[rr - ll + 1];
        Integer[] evens = new Integer[rr - ll + 1];
        int oddIndex = -1;
        int evenIndex = -1;
        //遍历原数组即可
        while (ll <= rr){
            lr = arr[ll++];
            if (lr % 2 == 0){
                evens[++evenIndex] = lr;
            }else {
                odds[++oddIndex] = lr;
            }
        }
        //遍历两个新的数组，将他们复制回去
        for (Integer odd : odds){
            if (odd == null) break;
            arr[begin++] = odd;
        }
        for (Integer even : evens){
            if (even == null) break;
            arr[begin++] = even;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,34,4,5,4,2,32,2};
        ReOrderArray func = new ReOrderArray();
        func.reOrderArray(arr);
        System.out.println("begin");
        System.out.println( Arrays.toString(arr));
        System.out.println("end");
    }
}
