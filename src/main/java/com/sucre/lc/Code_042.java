package com.sucre.lc;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author sucre
 * @desc https://leetcode.cn/problems/trapping-rain-water/
 * @date 2023/2/7
 */
public class Code_042 {

    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     * 示例 2：
     * <p>
     * 输入：height = [4,2,0,3,2,5]
     * 输出：9
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/trapping-rain-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        /**
         * 动态规划 和 单调递减栈都可以解这一题 具体参考
         * https://leetcode.cn/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
         */

        return 0;
    }

    public static int trapUseDp(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        //记录i位置左边最高元素的高度数组maxLeft[] 和i位置右边最高元素的高度数组maxRight[]
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        int i = 0;
        while (i < height.length) {
            if (i == 0) {
                maxLeft[i] = height[i];
            } else {
                maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
            }
            i++;
        }
        i = height.length - 1;
        while (i >= 0) {
            if (i == height.length - 1) {
                maxRight[i] = height[i];
            } else {
                maxRight[i] = Math.max(maxRight[i + 1], height[i]);
            }
            i--;
        }

        int sumWater = 0;
        i = 0;
        int waterHeight = 0;
        while (i < height.length) {
            waterHeight = Math.min(maxLeft[i], maxRight[i]);
            if (waterHeight > height[i]) {
                sumWater += (waterHeight - height[i]);
            }
            i++;
        }

        return sumWater;
    }

    public static int trapUseStack(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        Stack<Integer> decreaseStack = new Stack<>();
        int i = 0;
        int sumWater = 0;
        Integer topIndex = null;
        while (i < height.length) {
            topIndex = null;
            if (!decreaseStack.isEmpty()) {
                topIndex = decreaseStack.peek();
            }
            while (topIndex != null && height[topIndex] < height[i]) {
                Integer waterIndex = decreaseStack.pop();
                if (decreaseStack.isEmpty()) {
                    topIndex = null;
                } else {
                    topIndex = decreaseStack.peek();
                }
                if (topIndex != null) {
                    sumWater += ((i - topIndex - 1) * (Math.min(height[i], height[topIndex]) - height[waterIndex]));
                }
            }
            decreaseStack.push(i);
            i++;
        }

        return sumWater;
    }

    public static void main(String[] args) {
        System.out.println(trapUseStack(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
