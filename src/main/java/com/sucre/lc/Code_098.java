package com.sucre.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sucre
 * @desc https://leetcode.cn/problems/validate-binary-search-tree/?favorite=2cktkvj
 * @date 2023/2/13
 */
public class Code_098 {

    /**
     * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
     *
     * 有效 二叉搜索树定义如下：
     *
     * 节点的左子树只包含 小于 当前节点的数。
     * 节点的右子树只包含 大于 当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     *  
     *
     * 示例 1：
     *
     *
     * 输入：root = [2,1,3]
     * 输出：true
     * 示例 2：
     *
     *
     * 输入：root = [5,1,4,null,null,3,6]
     * 输出：false
     * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/validate-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    private Long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean leftResult = isValidBST(root.left);
        boolean rootResult = pre < root.val;
        pre = (long) root.val;
        return leftResult && rootResult && isValidBST(root.right);
    }

}
