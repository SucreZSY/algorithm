package com.sucre.swordoffer2.plan1;

/**
 * @author sucre
 * @desc https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bb9t833
 * @date 2023/2/14
 */
public class Code_10_2 {
    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     *
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     *
     * 示例 1：
     *
     * 输入：n = 2
     * 输出：2
     * 示例 2：
     *
     * 输入：n = 7
     * 输出：21
     * 示例 3：
     *
     * 输入：n = 0
     * 输出：1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public int numWays(int n) {
        //第n级台阶 可以从n-2直接跳过来 也可以从n-1跳过来， 也就是为f(n-1) + f(n-2)
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        int index = 2;
        while (index < (n + 1)) {
            dp[index] = mod1000000007(dp[index - 1], dp[index - 2]);
            index++;
        }
        return dp[n];
    }
    public static int mod1000000007(int left, int right) {
        return (left + right) % 1000000007;
    }
}
