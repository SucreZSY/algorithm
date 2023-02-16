package com.sucre.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sucre
 * @desc https://leetcode.cn/problems/spiral-matrix/?envType=study-plan&id=leetcode_75_level_2&plan=leetcode_75&plan_progress=ji1b1n7
 * @date 2023/2/16
 */
public class Code_054 {
    /**
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     *
     *  
     *
     * 示例 1：
     *
     *
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     * 示例 2：
     *
     *
     * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/spiral-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        //四个角分别是(0,0) (0,jLength - 1), (iLength - 1, jLength - 1), (iLength - 1, 0)
        int maxI = matrix.length - 1;
        int maxJ = matrix[0].length - 1;

        return new ArrayList<>();
    }
}
