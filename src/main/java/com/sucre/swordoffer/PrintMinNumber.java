package com.sucre.swordoffer;

import java.util.Arrays;

/**
 * 找到数组的最小组合
 */
public class PrintMinNumber {
    /**
     * 找到数组的最小组合
     * @param numbers 数组
     * @return 返回组合的字符串
     */
    public String PrintMinNumber(int[] numbers) {
        //很烦要自己写排序方法，直接转成Integer数组算了，使用jdk自带排序方便一点
        if (numbers == null || numbers.length == 0) return "";
        Integer[] arr = new Integer[numbers.length];
        int i = 0;
        for (int number : numbers) {
            arr[i++] = number;
        }
        Arrays.sort(arr, (a, b) -> ("" + a + b).compareTo("" + b + a));
        StringBuilder sb = new StringBuilder();
        for (Integer temp : arr){
            sb.append(temp);
        }
        return sb.toString();
    }
}
