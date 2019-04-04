package com.sucre.swordoffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 反向遍历链表
 */
public class ReversePrintList {
    public static class ListNode{
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 反向打印单向链表，这里对于递归有了限制，用stack进行优化
     * @param listNode 链表头
     * @return 返回反向打印的结果集
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        while (stack.size() != 0){
            arrayList.add(stack.pop());
        }
        return arrayList;
    }
}
