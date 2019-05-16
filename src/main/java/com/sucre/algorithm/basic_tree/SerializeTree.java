package com.sucre.algorithm.basic_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化和反序列化一颗二叉树
 */
public class SerializeTree {
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 序列化一颗二叉树
     * @param head 头结点
     * @return 返回序列化之后的结果
     */
    public static String serializeTree(Node head){
        //思路很简单
            //如果是null的话就返回 #_ 否则返回 value_
            //然后拼接左边返回的字符串和右边返回的字符串即可
        if (head == null) return "#_";
        String res = head.value + "_";
        res += serializeTree(head.left);
        res += serializeTree(head.right);
        return res;
    }

    /**
     * 反序列化一颗二叉树
     * @param res 序列化之后的结果
     * @return 返回头结点
     */
    public static Node recorTree(String res){
        String[] nodes = res.split("_");
        Queue<String> queue = new LinkedList<>();
        for (String temp : nodes){
            queue.add(temp);
        }
        return queueToTree(queue);
    }

    /**
     * 用于递归还原二叉树的方法
     * @param queue 存储着节点值的队列
     * @return 返回头结点
     */
    public static Node queueToTree(Queue<String> queue){
        String res = queue.poll();
        if ("#".equals(res)){
            return null;
        }else {
            Node head = new Node(Integer.parseInt(res));
            head.left = queueToTree(queue);
            head.right = queueToTree(queue);
            return head;
        }
    }

    /**
     * 使用queue改进递归，使用行序列化
     * @param head 头结点
     * @return 返回序列化后的字符串
     */
    public static String serializeTreeByLevel(Node head){
        if (head == null) return "#_";
        Queue<Node> nodes = new LinkedList<>();
        nodes.offer(head);
        String res = "";
        while (nodes.size() != 0){
            head = nodes.poll();
            if (head != null){
                res += head.value + "_";
                nodes.offer(head.left);
                nodes.offer(head.right);
            }else {
                res += "#_";
            }
        }
        return res;
    }

    /**
     * 行级反序列化
     * @param res 序列化结果
     * @return 反序列化后的头结点
     */
    public static Node recorTreeByLevel(String res){
        String[] nodes = res.split("_");
        Queue<Node> queue = new LinkedList<>();
        int index = 0;
        res = nodes[index++];
        Node head = generateNodeFromString(res);
        queue.offer(head);

        while (queue.size() != 0){
           head = queue.poll();
           if (head != null){
               head.left = generateNodeFromString(nodes[index++]);
               queue.offer(head.left);
               head.right = generateNodeFromString(nodes[index++]);
               queue.offer(head.right);
           }
        }

        return null;
    }

    /**
     * 根据字符串生成节点的方法
     * @param res 字符串
     * @return 生成的节点
     */
    public static Node generateNodeFromString(String res){
        if ("#".equals(res)){
            return null;
        }else {
            return new Node(Integer.parseInt(res));
        }
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
        Node head = null;
        printTree(head);

        String pre = serializeTree(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = recorTree(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        String level = serializeTreeByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = recorTreeByLevel(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

        head = new Node(1);
        printTree(head);

        pre = serializeTree(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = recorTree(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        level = serializeTreeByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = recorTreeByLevel(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

        head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.right.right = new Node(5);
        printTree(head);

        pre = serializeTree(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = recorTree(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        level = serializeTreeByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = recorTreeByLevel(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

        head = new Node(100);
        head.left = new Node(21);
        head.left.left = new Node(37);
        head.right = new Node(-42);
        head.right.left = new Node(0);
        head.right.right = new Node(666);
        printTree(head);

        pre = serializeTree(head);
        System.out.println("serialize tree by pre-order: " + pre);
        head = recorTree(pre);
        System.out.print("reconstruct tree by pre-order, ");
        printTree(head);

        level = serializeTreeByLevel(head);
        System.out.println("serialize tree by level: " + level);
        head = recorTreeByLevel(level);
        System.out.print("reconstruct tree by level, ");
        printTree(head);

        System.out.println("====================================");

    }
}
