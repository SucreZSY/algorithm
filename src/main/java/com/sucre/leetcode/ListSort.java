package com.sucre.leetcode;

/**
 * 给链表排序
 */
public class ListSort {


    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 考虑到复杂度限制在O(n*logn),链表又不好使用交换排序，因此选取归并
     * @param head 头结点
     * @return 排好序的链表
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        /*
        主要思路：
            找到链表中间节点，然后递归的把两边有序的链表归并
         */
        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null;//将两边打断
        //把左边排好序
        head = sortList(head);
        //把右边排好序
        right = sortList(right);
        return mergeList(head, right);
    }

    /**
     * 使用快慢指针找中点的方法
     * @param head 头结点
     * @return 中点
     */
    private ListNode getMid(ListNode head){
        ListNode fast = head;
        //快慢指针找重点
        while (fast != null && fast.next != null && fast.next.next != null){//保证当节点为偶数时，中点取前面的那个
            fast = fast.next.next;
            head = head.next;
        }
        return head;
    }

    /**
     * 合并两个有序链表的方法
     * @param left 左边的链表结点
     * @param right 右边的链表结点
     * @return 返回归并后的节点
     */
    private ListNode mergeList(ListNode left, ListNode right){
        if (left == null){
            return right;
        }
        if (right == null){
            return left;
        }

        ListNode node = left.val < right.val ? left : right;
        ListNode head = node;
        if (node == left){
            left = left.next;
        }else {
            right = right.next;
        }
        //循环比较左右链表节点的大小，谁小谁变成node的下一节点
        while (left != null && right != null){
            if (left.val < right.val){
                node.next = left;
                left = left.next;
            }else {
                node.next = right;
                right = right.next;
            }
            node = node.next;
        }
        if (left == null){
            node.next = right;
        }else {
            node.next = left;
        }
        return head;
    }


}
