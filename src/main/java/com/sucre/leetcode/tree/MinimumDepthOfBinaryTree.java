package com.sucre.leetcode.tree;

/**
 * 查找二叉树的最小深度
 */
public class MinimumDepthOfBinaryTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    /**
     * 查找二叉树的最小深度
     * @param root
     * @return
     */
    public int run(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null){
            return run(root.right) + 1;
        }
        if (root.right == null){
            return run(root.left) + 1;
        }
        return Math.min(run(root.left), run(root.right)) + 1;
    }

}
