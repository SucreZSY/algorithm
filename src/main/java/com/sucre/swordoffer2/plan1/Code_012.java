package com.sucre.swordoffer2.plan1;

/**
 * @author sucre
 * @desc https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bb9t833
 * @date 2023/2/27
 */
public class Code_012 {

    /**
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     *
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     *
     *  
     *
     * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
     *
     *
     *
     *  
     *
     * 示例 1：
     *
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * 输出：true
     * 示例 2：
     *
     * 输入：board = [["a","b"],["c","d"]], word = "abcd"
     * 输出：false
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() < 1) {
            return false;
        }
        if (board == null || board.length < 1 || board[0].length < 1) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean exist = dfs(board, i, j, 0, word);
                if (exist) {
                    return exist;
                }
            }
        }

        return false;
    }

    /**
     * 深度优先遍历 寻解
     * @param board
     * @param i
     * @param j
     * @param dfsIndex
     * @param word
     * @return
     */
    public boolean dfs(char[][] board, int i, int j, int dfsIndex, String word) {
        if (dfsIndex == word.length()) {
            return true;
        }
        if (outOfBoard(board, i, j)) {
            return false;
        }
        if (board[i][j] != word.charAt(dfsIndex)) {
            return false;
        }
        char cur = board[i][j];
        board[i][j] = ' ';
        //开始上下左右dfs
        dfsIndex++;
        boolean flag = dfs(board, i - 1, j, dfsIndex, word)
                || dfs(board, i + 1, j, dfsIndex, word)
                || dfs(board, i, j - 1, dfsIndex, word)
                || dfs(board, i , j + 1, dfsIndex, word);
        if (flag) {
            return true;
        }
        board[i][j] = cur;
        return false;
    }

    /**
     * 是否超过边界
     * @param board
     * @param i
     * @param j
     * @return
     */
    public boolean outOfBoard(char[][] board, int i, int j) {
        return (i < 0 || i >= board.length || j < 0 || j >= board[0].length);
    }
}
