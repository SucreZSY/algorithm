package com.sucre.algorithm.basic_tree;

import java.util.Stack;

/**
 * 三种不同的方式遍历二叉树，包括递归合肥递归
 */
public class PrintBinaryTree {
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 使用递归方式进行先序遍历
     * @param head 头结点
     */
    public static void prePrintTree(Node head){
        if(head == null) return ;
        //先打印当前节点，然后打印左子节点，再打印右子节点
        System.out.print(head.value + " ");
        prePrintTree(head.left);
        prePrintTree(head.right);
    }

    /**
     * 使用非递归的方式进行先序遍历
     * @param head 头结点
     */
    public static void prePrintTreeUnRescur(Node head){
        if (head == null) return ;
        //其实就是自己压栈的过程，先打印自身，然后只要右边节点不为空就把右边节点压入栈中，左边不为空就把左边也压入栈中
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (stack.size() != 0){
            head = stack.pop();
            System.out.println(head.value + " ");
            if (head.right != null){
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
        }
    }

    /**
     * 使用递归进行中序遍历
     * @param head 头结点
     */
    public static void midPrintTree(Node head){
        if (head == null) return ;
        //先打印左节点，再打印自身节点，再打印右节点
        midPrintTree(head.left);
        System.out.print(head.value + " ");
        midPrintTree(head.right);
    }

    /**
     * 使用非递归的方式进行中序遍历二叉树
     * @param head 头结点
     */
    public static void midPrintTreeUnRescur(Node head){
        //主要思路，直接把最左边一列全压入栈中，直到为null，为null就弹一个打印并将节点传递至右边
        if (head == null) return ;
        Stack<Node> stack = new Stack<>();
        while (stack.size() != 0 || head != null){
            if (head != null){
                stack.push(head);
                head = head.left;
            }else {
                head = stack.pop();
                System.out.print(head.value + " ");
                head = head.right;
            }
        }
    }

    /**
     * 使用递归进行后序遍历
     * @param head 头结点
     */
    public static void posPrintTree(Node head){
        if (head == null) return ;
        //先打印左节点，再打印右节点,再打印自身节点
        midPrintTree(head.left);
        midPrintTree(head.right);
        System.out.print(head.value + " ");
    }

    /**
     * 使用非递归的方法来进行后序遍历
     * @param head
     */
    public static void posPrintTreeUnRescur(Node head){
        if (head == null) return ;
        //主要思路：这种的遍历是左右中，不好操作，因此引入第二个栈，只要按中右左的顺序遍历数将节点压入第二个栈就可以了
        Stack<Node> help = new Stack<>();//用于存储倒序节点
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (stack.size() != 0){
            head = stack.pop();
            help.push(head);
            if (head.left != null){
                stack.push(head.left);
            }
            if (head.right != null){
                stack.push(head.right);
            }
        }
        while (help.size() != 0){
            System.out.print(help.pop().value + " ");
        }
    }




    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        posPrintTreeUnRescur(head);
        System.out.println();
    }
}
