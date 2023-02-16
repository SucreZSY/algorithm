package com.sucre.swordoffer2.plan1;

import java.util.Stack;

/**
 * @author sucre
 * @desc https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bb9t833
 * @date 2023/2/16
 */
public class Code_046 {

    /**
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: 12258
     * 输出: 5
     * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param num
     * @return
     */
    public int translateNum(int num) {
        if (num < 0) {
            return 1;
        }

        Stack<Integer> numStack = new Stack<>();
        int temp = num;
        while (temp > 0) {
            numStack.push(temp % 10);
            temp /= 10;
        }

        //当前位置必定可以贡献一种翻译, 当前一个数字 * 10 + 当前数字 在(当前数字, 25]范围, 则dp[i] = dp[i - 1] + dp[i - 2], 否则为dp[i] = dp[i - 1]
        int pre = 0;
        int kinds = 1;//i解法
        int lastKinds = 1;//i-1解法
        int last2Kinds = 1;//i-2解法
        int tempKinds;
        int pop;

        while (!numStack.isEmpty()) {
            pop = numStack.pop();
            pre = pre * 10 + pop;
            if (pre > pop && pre <= 25) {
                kinds = lastKinds + last2Kinds;
            } else {
                kinds = lastKinds;
            }
            last2Kinds = lastKinds;
            lastKinds = kinds;
            pre = pop;
        }

        return kinds;
    }
}
