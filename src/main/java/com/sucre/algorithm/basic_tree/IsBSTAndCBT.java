package com.sucre.algorithm.basic_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * BST：二叉搜索树
 * CBT：完全二叉树
 */
public class IsBSTAndCBT {
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 判断一棵二叉树是否是查找二叉树
     * @return 返回true 或者false
     */
    public static boolean isBST(Node head){
        //主要思路：
            //使用非递归的中序遍历，在需要打印的地方与上一次的值进行比较，如果比上一次的小就返回false
        if (head == null) return false;
        Stack<Node> stack = new Stack<>();
        int pre = Integer.MIN_VALUE;
        while (stack.size() != 0 || head != null){
            if (head != null){
                stack.push(head);
                head = head.left;
            }else {
                head = stack.pop();
                if (pre > head.value) return false;
                pre = head.value;
                head = head.right;
            }
        }
        return true;
    }

    /**
     * 判断一棵树是否是完全二叉树
     * @param head 头结点
     * @return true或者是false
     */
    public static boolean isCBT(Node head){
        //主要思路：
            //按层遍历，如果某个节点有右节点但是没有左节点，说明不是完全二叉树
                    //如果某个节点只有左节点或者没有子节点，那么他后面必须全是叶子节点
        if (head == null) return false;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        boolean flag = false;

        while (queue.size() != 0){
            head = queue.poll();
            if (flag && (head.left != null || head.right != null)){
                return false;
            }
            if (head.left == null && head.right != null) return false;

            if (head.left != null){
                queue.offer(head.left);
            }
            if (head.right != null){
                queue.offer(head.right);
            }else {
                flag = true;
            }
        }
        return true;
    }
    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);

        printTree(head);
        System.out.println(isBST(head));
        System.out.println(isCBT(head));

    }
}
