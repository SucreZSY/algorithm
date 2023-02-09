package com.sucre.swordoffer2.plan1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sucre
 * @desc https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bb9t833
 * @date 2023/2/8
 */
public class Code_035 {

}



class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


class Solution_035 {
    /**
     * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
     *
     *  
     *
     * 示例 1：
     *
     *
     *
     * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
     * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
     * 示例 2：
     *
     *
     *
     * 输入：head = [[1,1],[2,1]]
     * 输出：[[1,1],[2,1]]
     * 示例 3：
     *
     *
     *
     * 输入：head = [[3,null],[3,0],[3,null]]
     * 输出：[[3,null],[3,0],[3,null]]
     * 示例 4：
     *
     * 输入：head = []
     * 输出：[]
     * 解释：给定的链表为空（空指针），因此返回 null。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        //使用两个map
        // 1- 原链表node ： random指向的node
        // 2- 原链表node : copy的新node

        Map<Node, Node> mappingNodeMap = new HashMap<>();

        Node temp = head;
        while (temp != null) {
            Node newNode = new Node(temp.val);
            mappingNodeMap.put(temp, newNode);
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            Node newNode = mappingNodeMap.get(temp);
            newNode.next = mappingNodeMap.get(temp.next);
            newNode.random = mappingNodeMap.get(temp.random);
            temp = temp.next;
        }

        return mappingNodeMap.get(head);
    }
}
