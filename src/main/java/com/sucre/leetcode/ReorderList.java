package com.sucre.leetcode;

import java.util.Stack;

/**
 * 将链表变成特殊的顺序
 */
public class ReorderList {
    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 将l1 - l2 - l3 - ... - ln 变成 l1 - ln - l2 - ln-1 ...的顺序
     * @param head 链表头结点
     */
    public static void reorderList(ListNode head) {
        if (head == null) return;
        ListNode cur = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            cur = cur.next;
            fast = fast.next.next;//偶数时会停在前方
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = cur;
        while (cur.next != null){
            stack.push(cur.next);
            cur = cur.next;
        }
        temp.next = null;
        while (stack.size() != 0){
            temp = head.next;
            cur = stack.pop();
            head.next = cur;
            cur.next = temp;
            head = temp;
        }
    }
    public static void print(ListNode head){
        while (head != null){
            System.out.print(head.val + "-->");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
//        head.next.next.next.next.next.next = new ListNode(7);
        print(head);
        reorderList(head);
        System.out.println();
        print(head);
    }

}
