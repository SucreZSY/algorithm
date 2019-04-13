package com.sucre.leetcode;

/**
 * 使用插入排序对链表进行排序
 */
public class SortListByInserting {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
           val = x;
           next = null;
        }
    }

    /**
     * 使用插入排序对链表进行排序
     * @param head 链表的头结点
     * @return 排序后的头
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode cur = head.next;
        ListNode newHead = head;
        newHead.next = null;
        ListNode next;
        ListNode temp = newHead;
        ListNode pre = null;
        while (cur != null){
            next = cur.next;
            while (temp != null && temp.val < cur.val){//找到第一个比cur大的节点
                pre = temp;
                temp = temp.next;
            }
            if (temp == null){//没有比cur大的，说明要连在最后
                pre.next = cur;
                cur.next = null;
            }else if (pre == null){//新的头节点就比cur大
                cur.next = temp;
                newHead = cur;
            }else {//在中间找到了比cur大的
                cur.next = temp;
                pre.next = cur;
            }
            cur = next;
            temp = newHead;
            pre = null;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);

        SortListByInserting sortListByInserting = new SortListByInserting();
        ListNode listNode = sortListByInserting.insertionSortList(head);
        System.out.println(listNode.val);
        System.out.println(listNode.next.val);
        System.out.println(listNode.next.next.val);
    }


}
