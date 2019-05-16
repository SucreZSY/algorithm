package com.sucre.swordoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 自顶向下打印二叉树
 */
public class PrintTreeFromTop {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() != 0){
            root = queue.poll();
            res.add(root.val);
            if (root.left != null){
                queue.offer(root.left);
            }
            if (root.right != null){
                queue.offer(root.right);
            }
        }
        return res;
    }
}
