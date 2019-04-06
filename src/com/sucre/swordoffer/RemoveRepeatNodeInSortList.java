package com.sucre.swordoffer;

/**
 * 删除排序链表中的重复节点
 */
public class RemoveRepeatNodeInSortList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 删除排序链表中的重复节点,注意是只删除其中一个
     * @param pHead 头结点
     * @return 返回处理好之后的头结点
     */
    public ListNode deleteDuplication1(ListNode pHead) {
        /*
        主要思路：使用递归实现比较简单
         */
        if (pHead == null || pHead.next == null) return pHead;
        if (pHead.val == pHead.next.val){
            return deleteDuplication1(pHead.next);
        }else {
            pHead.next = deleteDuplication1(pHead.next);
            return pHead;
        }
    }

    /**
     * 删除排序链表中的重复节点,注意是只删除所有
     * @param pHead 头结点
     * @return 返回处理好之后的头结点
     */
    public ListNode deleteDuplication(ListNode pHead) {
        /*
        主要思路：使用递归实现比较简单
         */
        if (pHead == null || pHead.next == null) return pHead;
        int var = pHead.val;
        //找到和这个var相同的最后一个节点

        if (var != pHead.next.val){
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }else {
            while (pHead != null && pHead.val == var){
                pHead = pHead.next;//重复的情况下找到第一个不重复了的节点
            }
            return deleteDuplication(pHead);
        }
    }

}
