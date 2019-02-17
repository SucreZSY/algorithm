package com.sucre.algorithm.array_links;

/**
 * 反转单双链表
 */
public class RevearseList {
    public static class Node{
        public int value;

        public Node(int value) {
            this.value = value;
        }

        public Node next;
    }
    public static class DoubleNode{
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    /**
     * 反转单链表
     * @param head 单链表的头结点
     * @return 反转后的头结点
     */
    public static Node reverseList(Node head){
        if (head == null) throw new RuntimeException("error");
        Node cur = null;//已反转部分的头
        Node last = head;//未反转的头

        while (last != null){
            Node temp = last.next;//记录第三个节点，否则反转前两个后无法找到第三个
            last.next = cur;//将未反转的头连接已反转的头，便反转了一个
            cur = last;//将已反转的头更新为原来未反转的头
            last = temp;//将未反转的头更新为第三个
        }
        return cur;
    }

    /**
     * 反转双向链表
     * @param head 反转前的头结点
     * @return 反转后的头结点
     */
    public static DoubleNode reverseList(DoubleNode head){
        if (head == null) throw new RuntimeException("error");
        DoubleNode pre = head.last;
        DoubleNode next;
        while (head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void printLinkedList(Node head) {
        System.out.print("Linked List: ");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void printDoubleLinkedList(DoubleNode head) {
        System.out.print("Double Linked List: ");
        DoubleNode end = null;
        while (head != null) {
            System.out.print(head.value + " ");
            end = head;
            head = head.next;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.value + " ");
            end = end.last;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        printLinkedList(head1);
        head1 = reverseList(head1);
        printLinkedList(head1);

        DoubleNode head2 = new DoubleNode(1);
        head2.next = new DoubleNode(2);
        head2.next.last = head2;
        head2.next.next = new DoubleNode(3);
        head2.next.next.last = head2.next;
        head2.next.next.next = new DoubleNode(4);
        head2.next.next.next.last = head2.next.next;
        printDoubleLinkedList(head2);
        printDoubleLinkedList(reverseList(head2));

    }
}
