package com.sucre.leetcode.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 先序遍历二叉树
 */
public class PreOrderTraversal {
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    /**
     * 使用非递归的方式遍历二叉树
     * @param root 根节点
     * @return 遍历结果
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        //先把右边压栈，再把左边压栈，然后存当前的
        Stack<TreeNode> help = new Stack<>();
        help.push(root);
        while (help.size() != 0){
            root = help.pop();
            if (root.right != null){
                help.push(root.right);
            }
            if (root.left != null){
                help.push(root.left);
            }
            res.add(root.val);
        }
        return res;
    }

}
