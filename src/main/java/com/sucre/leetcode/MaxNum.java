package com.sucre.leetcode;

import java.util.Arrays;

/**
 * 返回一个数组的最大排列
 */
public class MaxNum {

    public static Integer getMaxNum(Integer[] nums){
        if (nums == null || nums.length < 1) return null;
        Arrays.sort(nums, (a, b) -> ("" + b + a).compareTo("" + a + b));
        StringBuffer pre = new StringBuffer();
        int i = 0;
        while (i < nums.length){
            pre.append(nums[i++]);
        }

        return Integer.parseInt(pre.toString());
    }

    public static void main(String[] args) {
        Integer[] nums = {11,33,0,5,32,6};
        System.out.println(getMaxNum(nums));
    }
}
