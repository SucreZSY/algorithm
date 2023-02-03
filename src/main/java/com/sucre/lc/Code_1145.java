package com.sucre.lc;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sucre
 * @desc https://leetcode.cn/problems/binary-tree-coloring-game/
 * @date 2023/2/3
 */
public class Code_1145 {
    /**
     * 有两位极客玩家参与了一场「二叉树着色」的游戏。游戏中，给出二叉树的根节点 root，树上总共有 n 个节点，且 n 为奇数，其中每个节点上的值从 1 到 n 各不相同。
     *
     * 最开始时：
     *
     * 「一号」玩家从 [1, n] 中取一个值 x（1 <= x <= n）；
     * 「二号」玩家也从 [1, n] 中取一个值 y（1 <= y <= n）且 y != x。
     * 「一号」玩家给值为 x 的节点染上红色，而「二号」玩家给值为 y 的节点染上蓝色。
     *
     * 之后两位玩家轮流进行操作，「一号」玩家先手。每一回合，玩家选择一个被他染过色的节点，将所选节点一个 未着色 的邻节点（即左右子节点、或父节点）进行染色（「一号」玩家染红色，「二号」玩家染蓝色）。
     *
     * 如果（且仅在此种情况下）当前玩家无法找到这样的节点来染色时，其回合就会被跳过。
     *
     * 若两个玩家都没有可以染色的节点时，游戏结束。着色节点最多的那位玩家获得胜利 ✌️。
     *
     * 现在，假设你是「二号」玩家，根据所给出的输入，假如存在一个 y 值可以确保你赢得这场游戏，则返回 true ；若无法获胜，就请返回 false 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/binary-tree-coloring-game
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     *
     *
     * 输入：root = [1,2,3,4,5,6,7,8,9,10,11], n = 11, x = 3
     * 输出：true
     * 解释：第二个玩家可以选择值为 2 的节点。
     * 示例 2 ：
     *
     * 输入：root = [1,2,3], n = 3, x = 1
     * 输出：false
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/binary-tree-coloring-game
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @param n
     * @param x
     * @return
     */
    public static boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        /**
         * 清晰易懂的题解: https://leetcode.cn/problems/binary-tree-coloring-game/solution/mei-you-si-lu-yi-zhang-tu-miao-dong-pyth-btav/
         *
         * 以x为根，玩家2可以在三块位置选择, x的左子树，x的右子树，x的父节点可拓展的位置 因此选择最大的一块， 只要这一块比玩家1的大， 即可获胜
         * 设玩家2最大涂色为 n2， 玩家1最大涂色为n1
         * 则获胜条件为n2 > n1
         * 已知 n2 = max(lcx, rcx, (n - 1 - lcx - rcx))(三块位置中最大的)
         * n1 = n - n2
         *
         * 则当 n2 > n - n2时, 可获胜
         * 则2*n2 > n
         */
        if (x < 1 || x > n) {
            return false;
        }
        if (root == null) {
            return false;
        }
        //定位到x
        TreeNode xNode = null;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode current = nodeQueue.poll();
            if (current.val == x) {
                xNode = current;
                break;
            }
            if (current.left != null) {
                nodeQueue.offer(current.left);
            }
            if (current.right != null) {
                nodeQueue.offer(current.right);
            }
        }
        if (xNode == null) {
            return false;
        }
        int leftCap = dfs(xNode.left);
        int rightCap = dfs(xNode.right);

        return (2 * Math.max(Math.max(leftCap, rightCap), (n - 1 - leftCap - rightCap))) > n;
    }

    public static int dfs(TreeNode head) {
        if (head == null) {
            return 0;
        }
        int leftCap = dfs(head.left);
        int rightCap = dfs(head.right);

        return leftCap + rightCap + 1;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
