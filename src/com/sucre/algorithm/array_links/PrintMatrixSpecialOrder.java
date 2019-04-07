package com.sucre.algorithm.array_links;
//之字形打印矩阵，打印外圈然后递归即可
public class PrintMatrixSpecialOrder {
    /**
     * 之字形打印矩阵
     * @param arr 目标矩阵
     * @param lr 左行号
     * @param lc 左列号
     * @param rr 右行号
     * @param rc 右列号
     * @param flag 打印的方向，true为向下打印，false为向上打印
     */
    public static void printMartrix(int[][] arr, int lr, int lc, int rr, int rc, boolean flag){
        if (lr < rr || lc > rc) return ;
        int lchelp = lc;
        int lrhelp = lr;
        int rchelp = rc;
        int rrhelp = rr;
        if (flag){//向下打印
            while (lr >= rr){
                System.out.println(arr[rr++][rc--]);
            }
        }else{//向上打印
            while (lr >= rr){
                System.out.println(arr[lr--][lc++]);
            }
        }
        if (lrhelp == arr.length - 1){
            lchelp++;
        }else {
            lrhelp++;
        }
        if (rchelp == arr[0].length - 1){
            rrhelp++;
        }else {
            rchelp++;
        }
        printMartrix(arr, lrhelp, lchelp, rrhelp, rchelp, !flag);
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        printMartrix(arr, 0,0,0,0,true);
    }
}
