package com.sucre.algorithm.sort_problem;

import com.sucre.algorithm.utils.ArrayUtils;

public class MaxGap_Problem {
    public static int maxGap(int[] arr){
        //求出数组中最大的数和最小的数
        if (arr == null || arr.length < 2){
            return 0;
        }
        int[] endPoints = ArrayUtils.findEndpoints(arr);
        int max = endPoints[0];
        int min = endPoints[1];

        if (max == min){
            return 0;
        }
        int len = arr.length;
        boolean[] hasNum = new boolean[len + 1];//记录桶中是否存入过值，方便最大值最小值的比较
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        for (int i : arr) {
            int bucketIndex = findBucketIndex(i, max, min, len);//找到当前值对应桶的下标
            maxs[bucketIndex] = hasNum[bucketIndex] ? Math.max(i, maxs[bucketIndex]) : i;
            mins[bucketIndex] = hasNum[bucketIndex] ? Math.min(i, mins[bucketIndex]) : i;
            hasNum[bucketIndex] = true;
        }

        //最大的间隔会存在于相邻两个有值的桶中
        int res = 0;
        int lastMin = mins[0];
        int i = 1;
        for ( ; i <= len; i++){
           if (hasNum[i]){
               res = Math.max(res, maxs[i] - lastMin);
               lastMin = mins[i];
           }
        }
        return res;
    }

    /**
     * 根据数组端点值和桶长度查询当前值对应桶下标的方法
     * @param value 当前值
     * @param max 最大值
     * @param min 最小值
     * @param len 桶长度
     * @return 返回在桶中的下标
     */
    public static int findBucketIndex(int value, int max, int min, int len){
        return (value - min) * len / (max - min);
    }

    public static void main(String[] args){
        int[] arr = {1,23,12341,1213,1,12,31,123,112,121,43,21,21,23,1,31,3,12,3,1,31,4,123,21,32,13,123,1,3,13,212};
        int maxGap = maxGap(arr);
        System.out.println(maxGap);
    }
}
