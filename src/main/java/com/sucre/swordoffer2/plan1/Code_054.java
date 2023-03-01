package com.sucre.swordoffer2.plan1;

/**
 * @author sucre
 * @desc https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bb9t833
 * @date 2023/3/1
 */
public class Code_054 {
    /**
     * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: root = [3,1,4,null,2], k = 1
     *    3
     *   / \
     *  1   4
     *   \
     *    2
     * 输出: 4
     * 示例 2:
     *
     * 输入: root = [5,3,6,2,4,null,null,1], k = 3
     *        5
     *       / \
     *      3   6
     *     / \
     *    2   4
     *   /
     *  1
     * 输出: 4
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        dfs(root, k);
        return res.val;
    }

    public void dfs(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        dfs(root.right, k);
        current++;
        if (current == k) {
            res = root;
        }
        dfs(root.left, k);
    }
    private int current = 0;
    private TreeNode res;
}
