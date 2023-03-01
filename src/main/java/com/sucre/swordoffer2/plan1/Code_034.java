package com.sucre.swordoffer2.plan1;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sucre
 * @desc https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/?envType=study-plan&id=lcof&plan=lcof&plan_progress=bb9t833
 * @date 2023/2/28
 */
public class Code_034 {
    /**
     * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
     *
     * 叶子节点 是指没有子节点的节点。
     *
     *  
     *
     * 示例 1：
     *
     *
     *
     * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
     * 输出：[[5,4,11,2],[5,8,4,5]]
     * 示例 2：
     *
     *
     *
     * 输入：root = [1,2,3], targetSum = 5
     * 输出：[]
     * 示例 3：
     *
     * 输入：root = [1,2], targetSum = 0
     * 输出：[]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @param target
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<Integer> pathList = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, target, pathList, res);
        return res;
    }

    /**
     * 深度优先遍历寻找路径
     * @param root
     * @param target
     * @return
     */
    public void dfs(TreeNode root, int target, LinkedList<Integer> pathList, List<List<Integer>> res) {
        if (root == null) {
            return;
        }

        pathList.add(root.val);
        if (isLeaf(root) && root.val == target) {
            res.add(new ArrayList<>(pathList));
        }
        dfs(root.left, target - root.val, pathList, res);
        dfs(root.right, target - root.val, pathList, res);
        pathList.removeLast();
    }


    public boolean isLeaf(TreeNode node) {
        if (node == null) {
            return false;
        }
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        Code_034 code = new Code_034();
        List<List<Integer>> lists = code.pathSum(node1, 4);

        System.out.println(JSONObject.toJSONString(lists));

    }
}
