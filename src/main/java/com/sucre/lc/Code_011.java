package com.sucre.lc;

/**
 * @author sucre
 * @desc https://leetcode.cn/problems/container-with-most-water/
 * @date 2023/2/6
 */
public class Code_011 {
    /**
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     *
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 返回容器可以储存的最大水量。
     *
     * 说明：你不能倾斜容器。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/container-with-most-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     * 示例 2：
     *
     * 输入：height = [1,1]
     * 输出：1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/container-with-most-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        /**
         * 最优解法： 双指针 参考：https://leetcode.cn/problems/container-with-most-water/solution/on-shuang-zhi-zhen-jie-fa-li-jie-zheng-que-xing-tu/
         *
         * 水的面积取决于较短的柱子, 当短的柱子固定时, 无论右边柱子怎么移动, 高度都不会超过短的柱子, 而宽度随着移动是在减小的, 因此要移动的一定是短的柱子
         */
        int maxArea = 0;
        if (height == null || height.length == 0) {
            return maxArea;
        }

        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            if (height[left] < height[right]) {
                maxArea = Math.max(height[left] * (right - left), maxArea);
                left++;
            } else {
                maxArea = Math.max(height[right] * (right - left), maxArea);
                right--;
            }
        }
        return maxArea;
    }
}
