package com.sucre.swordoffer2.plan1;

/**
 * @author sucre
 * @desc https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bb9t833
 * @date 2023/2/28
 */
public class Code_013 {
    /**
     * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
     *
     *  
     *
     * 示例 1：
     *
     * 输入：m = 2, n = 3, k = 1
     * 输出：3
     * 示例 2：
     *
     * 输入：m = 3, n = 1, k = 0
     * 输出：1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        if (m < 1 || n < 1) {
            return 0;
        }
        int[][] arr = new int[m][n];
        dfs(arr, 0, 0, k);

        return count;
    }
    public void dfs(int[][] arr, int i, int j, int k) {
        if (!canTouch(arr, i, j, k)) {
            return ;
        }
        count++;
        arr[i][j] = 1;
        dfs(arr, i, j - 1, k);
        dfs(arr, i, j + 1, k);
        dfs(arr, i - 1, j, k);
        dfs(arr, i + 1, j, k);
    }

    public boolean canTouch(int[][] arr, int i, int j, int k) {
        //越界
        if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length) {
            return false;
        }
        //重复遍历
        if (arr[i][j] == 1) {
            return false;
        }
        //数值不匹配
        return sumBit(i, j) <= k;
    }

    private int sumBit(int i, int j) {
        return sumBit(i) + sumBit(j);
    }
    private int sumBit(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }

    private int count = 0;


}
