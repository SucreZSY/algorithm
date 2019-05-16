package com.sucre.algorithm.array_links;

/**
 * 为单向链表进行partition过程
 */
public class SmallerEqualBigger {
    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 保证稳定性的算法，找到小的部分，相等的部分和大的部分，然后拼接起来
     * @param head 头结点
     * @param pivot 目标数值
     * @return 新链表的头结点
     */
    public static Node listPartition(Node head, int pivot){
        if (head == null) throw new RuntimeException("error");
        Node sH = null;//H是head的意思，T是tail的意思
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;

        while (head != null){
            if (head.value < pivot){
                if (sH == null){
                    sH = head;
                    sT = head;
                }else {
                    sT.next = head;
                    sT = head;
                }
            }else if(head.value == pivot){
                if (eH == null){
                    eH = head;
                    eT = head;
                }else {
                    eT.next = head;
                    eT = head;
                }
            }else {
                if (bH == null){
                    bH = head;
                    bT = head;
                }else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = head.next;
        }
        Node tail;//代表目前拼接的尾
        if (sT != null){//先把是s和e连接起来
            head = sH;
            sT.next = eH;
            tail = eH == null ? sT : eT;
        }else {
            head = eH;
            tail = eH == null ? null : eT;
        }

        if (head == null){
            return bH;
        }else {
            tail.next = bH;
        }
        if (bT != null){
            bT.next = null;
        }
        return head;
    }

    /**
     * 将链表转换为数组，然后调用partition过程后还原回去
     * 不保证稳定性
     * @param head 头结点
     * @param pivot 目标数据
     * @return 新链表的头结点
     */
    public static Node smallEqualBigByArray(Node head, int pivot){
        if (head == null) throw new RuntimeException("error");
        int i = 0;
        Node help = head;
        while (help != null){
            i++;
            help = help.next;
        }
        Node[] array = new Node[i];
        i = 0;
        //将链表转为数组
        while (head != null){
            array[i++] = head;
            head = head.next;
        }

        partitionArr(array, pivot);

        for (int j = 0; j < array.length; j++){
            if (j == 0){
                head = array[0];
                continue;
            }
            head.next = array[j];
            head = head.next;
        }
        array[array.length - 1].next = null;//把新链表最后的一个节点的next置为null，否则遍历起来就死循环了
        return array[0];
    }


    public static void swap(Node[] arr, int A, int B){
        Node temp = arr[A];
        arr[A] = arr[B];
        arr[B] = temp;
    }

    private static void partitionArr(Node[] arr, int pivot){
        int left = -1;
        int right = arr.length;
        int cur = 0;

        while (cur < right){
            if (arr[cur].value < pivot){
                swap(arr, ++left, cur++);
            }else if(arr[cur].value == pivot){
                cur++;
            }else {
                swap(arr, --right, cur);
            }
        }
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
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        // head1 = listPartition1(head1, 4);
        head1 = listPartition(head1, 9);
        printLinkedList(head1);

    }

}
