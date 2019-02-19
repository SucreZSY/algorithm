package com.sucre.algorithm.array_links;

/**
 * 找到两个单链表相交的第一个节点
 * 可能不相交，可能成环，也可能无环
 */
public class FindFirstIntersectNode {
    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2){
        if (head1 == null || head2 == null) return null;
        //先判断有没有环，返回各自成环的第一个节点
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);

        if (loop1 == null && loop2 == null){//必定都无环
            return noLoop(head1, head2);
        }else if(loop1 != null && loop2 != null){//必定都有环
            return bothLoop(head1, loop1, head2, loop2);
        }else{//一个有环，一个无环
            return null;
        }
    }

    /**
     * 判断一个单链表是否成环，成环返回第一个入环节点，没成环就返回null
     * @param head 待判断的链表头结点
     * @return 返回第一个入环的节点
     */
    public static Node getLoopNode(Node head){
        if (head == null || head.next == null || head.next.next == null) return null;//至少要三个节点才会成环
        Node slow = head.next;
        Node fast = head.next.next;

        while (slow != fast){//成环的话，快慢指针必定在环上相遇
            if(fast.next == null || fast.next.next == null) return null;//只要快指针后面有null就说明无环
            slow = slow.next;
            fast = fast.next.next;
        }
        //走到这一步说明必定有环，将快指针归位到head，变为慢指针，与原慢指针同时移动，相遇时必定是入环节点
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        //走到这一步，fast和slow都代表第一个入环的节点
        return fast;
    }

    /**
     * 返回两个必定无环的链表相交的第一个节点，相交的话返回第一个相交的节点，不相交就返回null
     * @param head1 第一条链表的头结点
     * @param head2 第二条链表得到头结点
     * @return 返回相交的第一个节点，如果不相交的话就返回null
     */
    public static Node noLoop(Node head1, Node head2){
        //先判断是否相交，获取到最后一个节点，相同则相交，否则就不相交
        if (head1 == null || head2 == null) return null;
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;//注意，两条链表相交之前的长度是不一致的，我们必须知道两条相差多少，便于寻找相交的第一个节点

        while (cur1.next != null){
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null){
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2){
            return null;
        }
        //执行到这里说明两条链表必定相交
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;//cur1永远代表长的那一个链表

        n = Math.abs(n);
        //因为cur1那一条链表比cur2长n，因此先移动n格保持与cur2同高
        while (n != 0){
            cur1 = cur1.next;
            n--;
        }
        //cur1和cur2同时移动，直到相同，相同的就是第一个相交的节点
        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    /**
     * 返回两个成环链表相交的第一个节点，可能相交也可能不相交，不相交就返回null
     * 为了判断究竟相不相交，需要传入两条链表的入环节点
     * @param head1 第一条链表的头结点
     * @param loop1 第一条链表的入环节点
     * @param head2 第二条链表的头结点
     * @param loop2 第二条链表的入环节点
     * @return 返回两条链表相交的第一个节点
     */
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2){
        if (head1 == null || head2 == null) return null;
        //如果两个入环节点相同，则必定相交,只不过是判断直接相交在环上还是相交后成环
        // 如果两个不同的话则可能相交也可能不相交，只需要，其中一个loop绕环一周看能否遇到另一个loop，相遇就表示相交,否则就不相交
        if (loop1 == loop2){
            //无论是哪种，直接找到两条链表的高度差，然后去除高度差遍历即可
            Node cur1 = head1;
            Node cur2 = head2;
            int n = 0;
            while (cur1 != loop1){
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2){
                n--;
                cur2 = cur2.next;
            }

            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;

            n = Math.abs(n);
            while (n != 0){
                n--;
                cur1 = cur1.next;
            }

            while (cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else{
            Node temp = loop1.next;//绕圈的指针
            while (temp != loop1){
                if (temp == loop2){ //说明两条链表第一个入环节点位于环上的不同位置，随表返回一个即可
                    return loop2;
                }
                temp = temp.next;
            }
            //到这一步说明两条链表是不同的环
            return null;
        }
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }



}
