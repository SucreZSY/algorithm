package com.sucre.algorithm.tree;

import java.security.interfaces.ECKey;
import java.util.UnknownFormatConversionException;

/**
 * 求完全二叉树节点个数的算法
 */
public class FindNodeNumInCBT {
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }


    public static int findNodeNum(Node head){
        if (head == null) return 0;
        //找到高度
        int height = 0;
        Node left = head;
        while (left != null){
            height++;
            left = left.left;
        }

        return findNodeNum(head, height, 1);
    }

    /**
     * 递归求节点个数的方法
     * @param head 头结点
     * @param height 树的总高度
     * @param level 当前头结点的层数，从1开始
     * @return 以次节点为头的树的节点个数
     */
    public static int findNodeNum(Node head, int height , int level){
        if (head == null) return 0;
        if (height == level) return 1;
        int i = height - level;
        Node right = head.right;
        while (i != 1){
            i--;
            right = right.left;
        }
        if (right != null){//左子树是满的
            return (1 << (height - level)) + findNodeNum(head.right, height, level + 1);
        }else {//右子树是满的
            return (1 << (height - level - 1)) + findNodeNum(head.left, height, level + 1);
        }
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        System.out.println(findNodeNum(head));

    }

}
