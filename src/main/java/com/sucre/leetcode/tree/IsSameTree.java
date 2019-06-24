package com.sucre.leetcode.tree;

/**
 * 判断两棵二叉树是否相同
 */
public class IsSameTree {
    /**
     * Definition for binary tree
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 判断两棵二叉树是不是相同
     * @param p 第一棵树的头
     * @param q 第二棵树的头
     * @return 是否相同
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        /*思路非常简单：两个都是空，相同，只有一个为空，不同，都不为空，比较自己的值和子树
         */
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
