package com.sucre.swordoffer2.plan1;

import java.util.List;

/**
 * @author sucre
 * @desc https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bb9t833
 * @date 2023/2/17
 */
public class Code_018 {
    /**
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     *
     * 返回删除后的链表的头节点。
     *
     * 注意：此题对比原题有改动
     *
     * 示例 1:
     *
     * 输入: head = [4,5,1,9], val = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     * 示例 2:
     *
     * 输入: head = [4,5,1,9], val = 1
     * 输出: [4,5,9]
     * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode newHead = head;

        ListNode pre = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            if (current.val == val) {
                if (pre == null) {
                    return next;
                } else {
                    pre.next = next;
                    return newHead;
                }
            } else {
                pre = current;
                current = next;
            }
        }
        return newHead;
    }
}
