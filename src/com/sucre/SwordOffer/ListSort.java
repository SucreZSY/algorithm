package com.sucre.SwordOffer;

import java.util.Arrays;
import java.util.Comparator;

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

    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        /*
        主要思路：
            将链表转化为数组，然后再对数组进行排序，最后拼接成链表返回回去
         */
        ListNode node = head;
        int i = 0;
        while (head != null){
            i++;
            head = head.next;
        }
        ListNode[] arr = new ListNode[i];
        while (node != null){
            arr[--i] = node;
            node = node.next;
        }
        Arrays.sort(arr, Comparator.comparingInt(l -> l.val));
        node = arr[0];
        head = node;
        arr[arr.length - 1].next = null;
        for (i = 1; i < arr.length; i++){
            node.next = arr[i];
            node = node.next;
        }
        return head;
    }

}
