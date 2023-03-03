package com.sucre.swordoffer2.plan1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author sucre
 * @desc https://leetcode.cn/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bb9t833
 * @date 2023/3/3
 */
public class Code_045 {
    /**
     * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: [10,2]
     * 输出: "102"
     * 示例 2:
     *
     * 输入: [3,30,34,5,9]
     * 输出: "3033459"
     *  
     *
     * 提示:
     *
     * 0 < nums.length <= 100
     * 说明:
     *
     * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
     * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }

        numsList.sort((a, b) -> (String.valueOf(a) + b).compareTo(String.valueOf(b) + a));
        StringBuilder sb = new StringBuilder();
        for (Integer num :numsList){
            sb.append(num);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("0121".compareTo("102"));
    }
}
