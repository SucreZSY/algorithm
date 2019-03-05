package com.sucre.SwordOffer;


import java.util.List;
import java.util.Stack;

/**
 * 反转链表
 */
@SuppressWarnings("all")
public class ReverseList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //不使用额外空间的反转方法，比较简单
    public ListNode ReverseList(ListNode head) {
       ListNode pre = null;
       ListNode next;

       while (head != null){
           next = head.next;
           head.next = pre;
           pre = head;
           head = next;
       }
       return pre;
    }
    //使用递归的方法，比较难想
    public ListNode ReverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = ReverseList1(head.next);//反转之后的头
        //找到尾节点
        ListNode last = newHead;
        while (last.next != null){
            last = last.next;
        }
        last.next = head;
        head.next = null;
        return newHead;
    }
    //使用栈，最简单
    public ListNode ReverseList3(ListNode head) {
        if(head == null) return null;
        Stack<ListNode> stack = new Stack<>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        head = stack.pop();
        ListNode node = head;
        while (stack.size() != 0){
            head.next = stack.pop();
            head = head.next;
        }
        head.next = null;
        return node;
    }
    //使用递归的方法，比较难想
    public ListNode ReverseList4(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = null;
        while(head != null){
            newHead = ReverseList4(head.next);//尾节点
        }
        ListNode node = newHead;
        while (node.next != null){
            node = node.next;
        }
        node.next = head;//把head连接到尾部
        head.next = null;
        return newHead;
    }
}
