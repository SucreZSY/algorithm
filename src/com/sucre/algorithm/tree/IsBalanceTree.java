package com.sucre.algorithm.tree;

/**
 * 判断一棵二叉树是不是平衡二叉树
 */
public class IsBalanceTree {
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
    public static class Res{
        public boolean isBalance;
        public int height;

        public Res(boolean isBalance, int height) {
            this.isBalance = isBalance;
            this.height = height;
        }
    }

    public static Res isBalanceTree(Node head){
        if (head == null) return new Res(true, 0);
        //找到左边的结果
        Res left = isBalanceTree(head.left);
        if (!left.isBalance) return new Res(false, ++left.height);
        //找到右边的结果
        Res right = isBalanceTree(head.right);
        if (!right.isBalance) return new Res(false, ++right.height);

        return Math.abs(left.height - right.height) > 1 ?
                new Res(false, Math.max(left.height, right.height) + 1) : new Res(true, Math.max(left.height, right.height) + 1);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        Res res = isBalanceTree(head);
        System.out.println("" + res.isBalance + res.height);
    }
}
