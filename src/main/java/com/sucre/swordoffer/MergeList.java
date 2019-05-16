package com.sucre.swordoffer;

/**
 * 合并两个有序链表
 */
public class MergeList {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 合并两个有序链表，使用递归
     * @param list1 第一条的头
     * @param list2 第二条的头
     * @return 合并后的头
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        //思路
            //取小的为头，递归连接下一段
        if (list1.val < list2.val){
            list1.next = Merge(list1.next, list2);
            return list1;
        }else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }

}
