package com.sucre.leetcode.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 非递归方式中序遍历二叉树
 */
public class InOrderTraversal {
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
     * 使用非递归来遍历二叉树
     * @param root
     * @return
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        while (stack.size() != 0 || root != null){
            if (root != null){
                while (root != null){
                    stack.push(root);
                    root = root.left;
                }
            }else {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

}
