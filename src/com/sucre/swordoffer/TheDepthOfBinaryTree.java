package com.sucre.swordoffer;

import sun.reflect.generics.tree.Tree;

/**
 * 查找二叉树的深度
 */
public class TheDepthOfBinaryTree {

     public class TreeNode {
         int val = 0;
         TreeNode left = null;
         TreeNode right = null;

         public TreeNode(int val) {
            this.val = val;
         }
     }

    /**
     * 查找二叉树的深度的算法
     * @param  root 根节点
     * @return 返回二叉树的深度
     */
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = TreeDepth(root.left);
        int rightHeight = TreeDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

}
