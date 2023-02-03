package com.sucre.lc;

import java.util.List;

/**
 * @author sucre
 * @desc https://leetcode.cn/problems/add-two-numbers/
 * @date 2023/2/3
 */
public class Code_002 {
    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     * 示例 2：
     *
     * 输入：l1 = [0], l2 = [0]
     * 输出：[0]
     * 示例 3：
     *
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * 输出：[8,9,9,9,0,0,0,1]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode pre = null;
        ListNode newHead = null;
        int left = 0;//进位标志
        while (l1 != null && l2 != null) {
            int finalVal = l1.val + l2.val + left;
            left = finalVal / 10;
            finalVal = finalVal % 10;
            ListNode current = new ListNode(finalVal);
            if (pre == null) {
                pre = current;
                newHead = current;
            } else {
                pre.next = current;
                pre = current;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode waitHandler = l1 == null ? l2 : l1;

        while (waitHandler != null) {
            int finalVal = waitHandler.val + left;
            left = finalVal / 10;
            finalVal = finalVal % 10;
            pre.next = new ListNode(finalVal);
            pre = pre.next;
            waitHandler = waitHandler.next;
        }

        if (left != 0) {
            pre.next = new ListNode(left);
        }

        return newHead;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
