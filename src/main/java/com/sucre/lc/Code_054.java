package com.sucre.lc;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sucre
 * @desc https://leetcode.cn/problems/spiral-matrix/?envType=study-plan&id=leetcode_75_level_2&plan=leetcode_75&plan_progress=ji1b1n7
 * @date 2023/2/16
 */
public class Code_054 {
    List<Integer> result;
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
        result = new ArrayList<>();
        int startI = 0;
        int endI = maxI;
        int startJ = 0;
        int endJ = maxJ;

        while (startI <= endI && startJ <= endJ) {
            spiralOuterOrder(matrix, startI, endI, startJ, endJ);
            startI++;
            endI--;
            startJ++;
            endJ--;
        }

        return result;
    }

    /**
     * 打印外圈
     * @param matrix
     * @param startI
     * @param endI
     * @param startJ
     * @param endJ
     */
    public void spiralOuterOrder(int[][] matrix, int startI, int endI, int startJ, int endJ) {
        int i = startI;
        int j = startJ;
        if (startI == endI) {//只有一行 直接打印完即可
            while (j <= endJ) {
                result.add(matrix[i][j++]);
            }
            return;
        }
        if (startJ == endJ) {//只打印一列
            while (i <= endI) {
                result.add(matrix[i++][j]);
            }
            return;
        }

        while (j < endJ) {
            result.add(matrix[i][j++]);
        }
        while (i < endI) {
            result.add(matrix[i++][j]);
        }
        while (j > startJ) {
            result.add(matrix[i][j--]);
        }
        while (i > startI) {
            result.add(matrix[i--][j]);
        }

    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1}};

        Code_054 code_054 = new Code_054();
        code_054.spiralOuterOrder(matrix, 0, 0, 0, 0);
        System.out.println(JSONObject.toJSONString(code_054.result));
    }

}
