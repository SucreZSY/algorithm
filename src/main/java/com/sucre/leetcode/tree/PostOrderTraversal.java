package com.sucre.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * 使用递归版和非递归版实现后续遍历
 */
@SuppressWarnings("all")
public class PostOrderTraversal {
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
     * 递归版，非常简单
     * @param root 根节点
     * @return 后序遍历的序列
     */
    public ArrayList<Integer> postorderTraversal1(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        ArrayList<Integer> left = postorderTraversal(root.left);
        ArrayList<Integer> right = postorderTraversal(root.right);
        //先收集左边，再收集右边，最后收集自己
        Collections.addAll(res, (Integer[]) left.toArray());
        Collections.addAll(res, (Integer[]) right.toArray());

        res.add(root.val);
        return res;
    }
    /**
     * 非递归版，使用栈
     * @param root 根节点
     * @return 后序遍历的序列
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> temp = new Stack<>();
        Stack<TreeNode> stack = new Stack<>();
        temp.push(root);
        while (temp.size() != 0){
            root = temp.pop();
            stack.push(root);
            if (root.left != null) temp.push(root.left);
            if (root.right != null) temp.push(root.right);
        }
        while (stack.size() != 0){
            res.add(stack.pop().val);
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
