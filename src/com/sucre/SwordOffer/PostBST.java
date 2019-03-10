package com.sucre.SwordOffer;

/**
 * 判断一个数组是否是搜索二叉树的后序数列
 */
public class PostBST {
    /**
     * 后序遍历数列判断
     * @param sequence 序列
     * @return true：合法 反之不合法
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        //主要思路
            //后序遍历数列的结构  最左 》 左子节点（比根小） 》 右子节点 》 根
            //因此需要从右往左找到左子节点，然后判断左子节点左边是否都是比根小的。然后再递归的判断左子树和右子树是否是BST
        if (sequence == null || sequence.length == 0) return false;
        return isBST(sequence, 0, sequence.length - 1);
    }

    private boolean isBST(int[] arr, int left, int root){
        if (left >= root) return true;

        int index = root;//找到左子节点
        while (index > left && arr[index] >= arr[root]){
            index--;
        }
        for (int i = left; i < index; i++){
            //左边应该都要比根小
            if (arr[i] > arr[root]) return false;
        }
        //判断左子树是否是bst和右子树是否为bst
        return isBST(arr, left, index) && isBST(arr, index + 1, root - 1);//解释，左子节点右边是右子树第一个节点，根节点左边是右子节点
    }
}
