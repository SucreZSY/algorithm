package com.sucre.SwordOffer;

import java.util.List;

/**
 * 倒数第k个节点
 */
public class LastKNode {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 倒数第k个节点
     * @param head 头结点
     * @param k k的值
     * @return 节点
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        //思路：找到第k个节点
        ListNode node = head;
        while (k != 0){
            if (node == null){
                return null;
            }
            node = node.next;
            k--;
        }
        //第k个节点与头结点一起移动，当第k个到底的时候说明头结点到了倒数第k个
        while (node != null){
            head = head.next;
            node = node.next;
        }
        return head;
    }
}
