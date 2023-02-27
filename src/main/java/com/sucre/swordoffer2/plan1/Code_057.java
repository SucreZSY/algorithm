package com.sucre.swordoffer2.plan1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author sucre
 * @desc https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bb9t833
 * @date 2023/2/27
 */
public class Code_057 {

    /**
     * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[2,7] 或者 [7,2]
     * 示例 2：
     *
     * 输入：nums = [10,26,30,31,47,60], target = 40
     * 输出：[10,30] 或者 [30,10]
     *  
     *
     * 限制：
     *
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^6
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[] {};
        }
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            sub = target - nums[left];
            if (sub == nums[right]) {
                return new int[] {nums[left], nums[right]};
            }
            if (sub > nums[right]) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {};
    }
    int sub;

}
