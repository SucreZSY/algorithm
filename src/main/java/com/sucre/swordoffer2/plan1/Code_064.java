package com.sucre.swordoffer2.plan1;

/**
 * @author sucre
 * @desc https://leetcode.cn/problems/qiu-12n-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bb9t833
 * @date 2023/3/7
 */
public class Code_064 {
    /**
     * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     *
     *  
     *
     * 示例 1：
     *
     * 输入: n = 3
     * 输出: 6
     * 示例 2：
     *
     * 输入: n = 9
     * 输出: 45
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/qiu-12n-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public int sumNums(int n) {
        return (1 + n) * n / 2;
    }
}
