package com.sucre.lc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sucre
 * @desc https://leetcode.cn/problems/happy-number/?envType=study-plan&id=leetcode_75_level_2&plan=leetcode_75&plan_progress=ji1b1n7
 * @date 2023/2/16
 */
public class Code_202 {

    /**
     * 编写一个算法来判断一个数 n 是不是快乐数。
     *
     * 「快乐数」 定义为：
     *
     * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
     * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
     * 如果这个过程 结果为 1，那么这个数就是快乐数。
     * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：n = 19
     * 输出：true
     * 解释：
     * 12 + 92 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1
     * 示例 2：
     *
     * 输入：n = 2
     * 输出：false
     *  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/happy-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        //使用快慢指针 慢的一次求一次平方和, 快的一次求两次平方和， 要么快指针可以追上慢指针， 要么快指针或慢指针成为了1
        int slow = n;
        int fast = n;

        do {
            slow = sum(slow);
            if (slow == 1) {
                return true;
            }
            fast = sum(fast);
            fast = sum(fast);
            if (fast == 1) {
                return true;
            }
        } while (slow != fast);
        return false;
    }

    public int sum(int n) {
        int sum = 0;
        int left;
        while (n > 0) {
            left = n % 10;
            n /= 10;
            sum += left * left;
        }
        return sum;
    }
}
