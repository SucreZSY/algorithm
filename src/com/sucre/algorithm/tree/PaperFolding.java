package com.sucre.algorithm.tree;

/**
 * 折纸问题
 */
public class PaperFolding {
    /**
     * 打印N次对折后的折痕，模拟二叉树中序遍历
     * @param level 当前遍历的层数,从1开始
     * @param N 总对折数，相当于二叉树总层数
     * @param down 当前节点是否为down，头结点必定为down
     */
    public static void printFolding(int level, int N, boolean down){
        if (level > N) return ;
        //先打印左子树
        printFolding(level + 1, N, true);//左子树必定为down
        //打印自身节点
        System.out.print(down ? "down  " : "up  ");
        //打印右子树
        printFolding(level + 1, N, false);//右子树必定为up
    }

    /**
     * 提供用户访问入口
     * @param N 折纸的次数
     */
    public static void printFolding(int N){
        printFolding(1, N, true);
    }

    public static void main(String[] args) {
        printFolding(1);
        System.out.println();
        printFolding(2);
        System.out.println();
        printFolding(3);
    }
}
