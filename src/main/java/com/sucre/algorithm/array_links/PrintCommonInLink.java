package com.sucre.algorithm.array_links;

/**
 * 打印两个有序单链表的公共部分
 */
public class PrintCommonInLink {
    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 打印两个有序链表相同的部分
     * @param head1 第一个链表的头
     * @param head2 第二个链表的头
     */
    public static void printCommonPart(Node head1, Node head2){
        if (head1 == null || head2 == null) return ;
        while (head1 != null && head2 != null){
            if (head1.value == head2.value){
                System.out.println(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
            if (head1.value > head2.value){
                head2 = head2.next;
            }else{
                head1 = head1.next;
            }
        }
    }
    public static void printLinkedList(Node node){
        while (node != null){
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.next = new Node(3);
        node1.next.next = new Node(5);
        node1.next.next.next = new Node(6);

        Node node2 = new Node(1);
        node2.next = new Node(2);
        node2.next.next = new Node(5);
        node2.next.next.next = new Node(7);
        node2.next.next.next.next = new Node(8);

        printLinkedList(node1);
        printLinkedList(node2);
        printCommonPart(node1, node2);

    }


}
