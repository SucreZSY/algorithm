package com.sucre.swordoffer;

/**
 * 找到一个链表的第一个入环节点
 */
public class TheFirstRingNodeInQueue {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    /**
     * 找到一个链表的第一个入环节点
     * @param pHead 给定链表的头
     * @return 第一个入环节点
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        /*
        主要思路：使用快慢指针解决，快指针一次两步，慢指针一次一步，相遇的话就一定在环上
                相遇后，快指针归0，变为慢指针与慢指针一起移动直到相遇
         */
        if (pHead == null || pHead.next == null) return null;
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
        while (fast != slow && fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast == slow){
            fast = pHead;
            while (fast != slow){
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
        return null;
    }

}
