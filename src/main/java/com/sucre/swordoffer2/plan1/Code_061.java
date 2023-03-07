package com.sucre.swordoffer2.plan1;

import java.util.Arrays;

/**
 * @author sucre
 * @desc https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bb9t833
 * @date 2023/3/6
 */
public class Code_061 {

    /**
     * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: [1,2,3,4,5]
     * 输出: True
     *  
     *
     * 示例 2:
     *
     * 输入: [0,0,1,2,5]
     * 输出: True
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public static boolean isStraight(int[] nums) {
        if (nums == null || nums.length != 5) {
            return false;
        }
        int firstNotGhostIndex = 0;
        Arrays.sort(nums);
        int preNum = 0;
        for (int num : nums) {
            if (num < 0 || num > 13) {
                return false;
            }
            if (num == 0) {
                firstNotGhostIndex++;
                continue;
            }
            if (preNum == 0) {
                preNum = num;
                continue;
            }
            if (preNum == num) {
                return false;
            }
            preNum = num;
        }
        firstNotGhostIndex = Math.min(firstNotGhostIndex, 4);
        return (nums[4] - nums[firstNotGhostIndex]) < 5;
    }

    public static void main(String[] args) {
        System.out.println(isStraight(new int[] {13,13,9,10,12}));
    }
}
