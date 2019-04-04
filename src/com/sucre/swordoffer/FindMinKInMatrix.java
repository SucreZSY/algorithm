package com.sucre.swordoffer;

import com.sucre.algorithm.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 找到数组中最小的k个数
 */
public class FindMinKInMatrix {
    /**
     * 找到数组中最小的k个数
     * @param input 数组
     * @param k 给定查找的个数
     * @return 最小的k个数集合
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

        /*
        主要思路：
            这一题如果用排序或者堆来做的话比较简单，时间复杂度是O（n log n），可以用BFPRT算法来优化,使时间复杂度为O（n），BFPRT找绝对中位数比较麻烦
            我用了缩水版的BFPRT，直接使用随机的partition来代替
         */
        if (input == null || input.length == 0 || k > input.length){
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        if (k == input.length){
            for (int i : input){
                res.add(i);
            }
            return res;
        }
        return getLastK(input, 0, input.length - 1, k);
    }

    /**
     * 在指定下标范围内找最小的k个数
     * @param input 目标数组
     * @param left 起点
     * @param right 终点
     * @param k 查找个数
     * @return 查找结果
     */
    public ArrayList<Integer> getLastK(int[] input, int left, int right, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        //对数组进行patition过程
        int[] par = partition(input, left, right);
        if (par[0] <= k && par[1] >= k){//k在相等区域,直接返回
            while (k-- != 0){
                res.add(input[k]);
            }
            return res;
        }else if (par[0] > k){//k在左边
            return getLastK(input, left, par[0] - 1, k);
        }else {//在右边
            return getLastK(input, par[1] + 1, right, k);
        }
    }


    /**
     * 对数组进行随机partition过程
     * @param arr 目标数组
     * @param start 起点
     * @param stop 终点
     * @return 相等区域下标的数组
     */
    public int[] partition(int[] arr, int start, int stop){
        if (arr == null || arr.length <= 1){
            return new int[]{start, stop};//这里数组其实是肯定有值的
        }
        int index = (int) (Math.random() * (stop - start) + start);//产生随机的下标
        int pivot = arr[index];
        int left = start - 1;
        int right = stop + 1;
        while (start < right){
            if (arr[start] < pivot){
                ArrayUtils.swap(arr, start++, ++left);
            }else if (arr[start] == pivot){
                start++;
            }else {
                ArrayUtils.swap(arr, start, --right);
            }
        }
        return new int[]{left + 1, right - 1};
    }

    public static void main(String[] args) {
        FindMinKInMatrix demo = new FindMinKInMatrix();
        int[] arr = {4,5,1,6,2,7,3,8};
        System.out.println(demo.GetLeastNumbers_Solution(arr, 2));
    }
}
