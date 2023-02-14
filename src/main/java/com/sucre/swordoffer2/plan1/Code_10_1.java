package com.sucre.swordoffer2.plan1;

/**
 * @author sucre
 * @desc https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bb9t833
 * @date 2023/2/14
 */
public class Code_10_1 {
    /**
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
     *
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
     *
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：n = 2
     * 输出：1
     * 示例 2：
     *
     * 输入：n = 5
     * 输出：5
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
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


    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE/2);
        System.out.println(1000000007);
    }

}
