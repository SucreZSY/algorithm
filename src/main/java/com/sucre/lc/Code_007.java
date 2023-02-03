package com.sucre.lc;

/**
 * @author sucre
 * @desc 题目: https://leetcode.cn/problems/reverse-integer/
 * @date 2023/2/3
 */
public class Code_007 {

    /**
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     *
     * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
     *
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     *  
     *
     * 示例 1：
     *
     * 输入：x = 123
     * 输出：321
     * 示例 2：
     *
     * 输入：x = -123
     * 输出：-321
     * 示例 3：
     *
     * 输入：x = 120
     * 输出：21
     * 示例 4：
     *
     * 输入：x = 0
     * 输出：0
     *  
     *
     * 提示：
     *
     * -231 <= x <= 231 - 1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/reverse-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param x
     * @return
     */
    public static int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        int flag = 1;
        if (x < 0) {
            flag = -1;
            x = -x;
        }
        long res = 0;//初始化最终结果
        //每次取最后一位放到最前方
        while (x > 0) {
            int temp = x % 10;
            res = res * 10 + temp;

            if (res > 2147483647 || -res < -2147483648) {
                return 0;
            }

            x = x / 10;
        }

        return (int) res * flag;
    }

    public static void main(String[] args) {
        int i = 1;
        int index = 0;
        while (index < 31) {
            i = i * 2;
            index++;
        }
        System.out.println(i - 1);
        System.out.println(i);
    }
}
