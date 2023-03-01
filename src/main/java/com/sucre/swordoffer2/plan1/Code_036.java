package com.sucre.swordoffer2.plan1;

/**
 * @author sucre
 * @desc https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bb9t833
 * @date 2023/3/1
 */
public class Code_036 {
    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
     *
     *  
     *
     * 为了让您更好地理解问题，以下面的二叉搜索树为例：
     *
     *  
     *
     *
     *
     *  
     *
     * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
     *
     * 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
     *
     *  
     *
     *
     *
     *  
     *
     * 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            root.left = root;
            root.right = root;
            return root;
        }

        dfs(root);
        newHead.left = pre;
        pre.right = newHead;
        return newHead;
    }

    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == null) {
            newHead = root;
        } else {
            pre.right = root;
            root.left = pre;
        }
        pre = root;
        dfs(root.right);
    }

    private Node newHead;
    private Node pre;

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}
