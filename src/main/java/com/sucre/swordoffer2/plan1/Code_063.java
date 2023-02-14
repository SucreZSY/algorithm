package com.sucre.swordoffer2.plan1;

/**
 * @author sucre
 * @desc https://leetcode.cn/problems/gu-piao-de-zui-da-li-run-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bb9t833
 * @date 2023/2/14
 */
public class Code_063 {
    /**
     * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
     *
     *  
     *
     * 示例 1:
     *
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     * 示例 2:
     *
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/gu-piao-de-zui-da-li-run-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        //使用二维数组 i代表i天买 j代表j天卖 值为利润 i < j
        if (prices == null || prices.length < 1) {
            return 0;
        }

        //int[][] profitArr = new int[prices.length][prices.length];
        int maxProfit = 0;
        int i = 0;
        int j;
        while (i < prices.length) {
            j = i + 1;
            while (j < prices.length) {
                maxProfit = Math.max(maxProfit, prices[j++] - prices[i]);
            }
            i++;
        }
        return maxProfit;
    }

}
