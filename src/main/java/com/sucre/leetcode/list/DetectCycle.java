package com.sucre.leetcode.list;

/**
 * 找到链表的第一个入环节点，如果没有环就返回null
 */
public class DetectCycle {

     static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
     }

    public static ListNode detectCycle(ListNode head) {
         /*
         主要思路：
            快慢指针，如果能遇到就说明有环，将快指针归零，然后和慢指针一起走，再次相遇就是第一个入环节点
                    快指针如果到底，就说明没有环
          */
         if (head == null || head.next == null){
             return null;
         }

         ListNode fast = head.next.next;
         ListNode slow = head.next;

         while (fast != null && fast.next != null && fast != slow){
             fast = fast.next.next;
             slow = slow.next;
         }

         //如果fast != slow 就说明无环
         if (fast != slow){
             return null;
         }
         fast = head;

         while (fast != slow){
             fast = fast.next;
             slow = slow.next;
         }
         return fast;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);

        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node3;

        System.out.println(detectCycle(head1).val);

    }
}
