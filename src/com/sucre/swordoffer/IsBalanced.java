package com.sucre.swordoffer;

/**
 * 判断一颗树是否是平衡二叉树
 */
public class IsBalanced {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode (int x) {
            val = x;
        }
    }
    public boolean IsBalanced_Solution(TreeNode root) {
        return isBalance(root).isBalance;
    }
    public Result isBalance(TreeNode node){
        if (node == null) return new Result(true, 0);
        Result left = isBalance(node.left);
        if (!left.isBalance){
            return new Result(left.isBalance, left.height + 1);
        }
        Result right = isBalance(node.right);
        if (!right.isBalance){
            return new Result(right.isBalance, right.height + 1);
        }
        return Math.abs(left.height - right.height) > 1 ? new Result(false, Math.max(left.height, right.height) + 1) : new Result(true, Math.max(left.height, right.height) + 1);
    }

    public class Result{
        public boolean isBalance;
        public int height;

        public Result(boolean isBalance, int height){
            this.isBalance = isBalance;
            this.height = height;
        }
    }
}
