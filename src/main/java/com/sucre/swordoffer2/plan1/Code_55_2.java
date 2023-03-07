package com.sucre.swordoffer2.plan1;

/**
 * @author sucre
 * @desc https://leetcode.cn/problems/ping-heng-er-cha-shu-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bb9t833
 * @date 2023/3/7
 */
public class Code_55_2 {
    /**
     * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
     *
     *  
     *
     * 示例 1:
     *
     * 给定二叉树 [3,9,20,null,null,15,7]
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回 true 。
     *
     * 示例 2:
     *
     * 给定二叉树 [1,2,2,3,3,null,null,4,4]
     *
     *        1
     *       / \
     *      2   2
     *     / \
     *    3   3
     *   / \
     *  4   4
     * 返回 false 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/ping-heng-er-cha-shu-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root [1,2,3,4,5,null,6,7,null,null,null,null,8]
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        Height dfs = dfs(root);
        return dfs.isBalanced;
    }

    public Height dfs(TreeNode root) {
        if (root == null) {
            return new Height(true, 0);
        }
        Height left = dfs(root.left);
        Height right = dfs(root.right);

        if (!left.isBalanced) {
            return left;
        }
        if (!right.isBalanced) {
            return right;
        }
        if (Math.abs(left.height - right.height) > 1) {
            return new Height(false, 0);
        }
        return new Height(true, Math.max(left.height, right.height) + 1);
    }

    public static class Height {
        public boolean isBalanced;
        public int height;

        public Height(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}
