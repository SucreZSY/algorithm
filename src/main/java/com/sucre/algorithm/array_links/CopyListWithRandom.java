package com.sucre.algorithm.array_links;

import java.util.HashMap;
import java.util.Map;

/**
 * 复制包含随机节点的链表
 */
public class CopyListWithRandom {
    public static class Node{
        public int value;
        public Node next;
        public Node rand;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 使用hashmap复制包含随机节点的链表
     * @param head 待复制链表头结点
     * @return 复制后的链表的头结点
     */
    public static Node copyListWithRand1(Node head){
        if (head == null) return null;
        Node help = head;
        Node old = head;
        Map<Node, Node> map = new HashMap<>();
        while (head != null){
            map.put(head, new Node(head.value));
            head = head.next;
        }
        head = map.get(help);
        Node cur = head;
        //设置next链
        while (help != null){
            cur.next = map.get(help.next);
            help = help.next;
            cur = cur.next;
        }
        //设置random
        cur = head;
        while (cur != null){
            cur.rand = map.get(old.rand);
            cur = cur.next;
            old = old.next;
        }
        return head;
    }

    /**
     * 不使用hashmap的复制随机链表
     * 把整个链表设计成一种有规律的状态，把所有的新节点都连接在原来对应节点的后面
     * 1 -> 1(新) -> 2 -> 2(新) -> 3 -> 3(新)
     * 就像这样，这样也能根据原节点找到对应的复制节点
     * @param head 待复制的链表头
     * @return 复制后的链表头
     */
    public static Node copyListWithRand2(Node head){
        if (head == null) return null;

        //先记录好原来的头节点不要动
        Node old = head;
        //把结构变成有规律的
        Node temp;
        while (head != null){
            temp = head.next;
            head.next = new Node(head.value);
            head.next.next = temp;
            head = temp;
        }

        //连接好rand
        head = old;
        while (head != null){
            temp = head.next;
            temp.rand = head.rand == null ? null : head.rand.next;
            head = temp.next;
        }

        //连接好next
        temp = old.next;
        head = old.next;
        while (old != null){
           old.next = temp.next;
           temp.next = (old.next == null) ? null : old.next.next;
           old = old.next;
           temp = temp.next;
        }
        return head;
    }
    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head = null;
        Node res1 = null;
        Node res2 = null;
        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

//        printRandLinkedList(head);
//        res1 = copyListWithRand1(head);
//        printRandLinkedList(res1);


        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

    }
}
