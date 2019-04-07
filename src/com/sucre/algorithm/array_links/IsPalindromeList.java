package com.sucre.algorithm.array_links;

/**
 * 判断单链表是否为回文结构，找到中点，把重点后面的部分全部转置即可
 */
public class IsPalindromeList {
    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    public static boolean isPalindromeList(Node head){
        if (head == null || head.next == null) return true;
        boolean flag = true;
        //找到中点
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null){
            n1 = n1.next;
            n2 = n2.next.next;
        }
        //转置后面的链表
        n2 = n1.next;
        n1.next = null;
        Node n3;

        while (n2 != null){
            n3 = n2.next;
            n2.next = n1;
            n1  = n2;
            n2 = n3;
        }
        //这时候n1是最右边的端点
        n3 = n1;//方便恢复
        n2 = head;//让n2作为最左边的端点
        while (n2 != null){
            if (n2.value != n1.value){
                flag = false;
                break;
            }
            n2 = n2.next;
            n1 = n1.next;
        }

        //要把数据源恢复
        n1 = null;
        while (n3 != null){
            n2 = n3.next;
            n3.next = n1;
            n1 = n3;
            n3 = n2;
        }
        return flag;
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head = null;
        printLinkedList(head);
        System.out.println(isPalindromeList(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindromeList(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        System.out.println(isPalindromeList(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindromeList(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        System.out.println(isPalindromeList(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindromeList(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindromeList(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindromeList(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindromeList(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

    }
}
