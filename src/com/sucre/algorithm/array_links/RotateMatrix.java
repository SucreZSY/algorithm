package com.sucre.algorithm.array_links;

import java.util.Arrays;

//1.旋转打印矩阵
//2.旋转正方形矩阵
public class RotateMatrix {
    /**
     * 使用递归打印一个矩阵的方法
     * @param arr 目标矩阵
     * @param lr 左上角行号
     * @param lc 左上角列号
     * @param rr 右下角行号
     * @param rc 右下角列号
     */
    public static void rotateMatrix(int[][] arr, int lr, int lc, int rr, int rc){
        //如果左边的坐标超过了右边，说明打印完毕了
        if (lr > rr || lc > rc){
            return;
        }
        //记录好左边的坐标，因为动的是左边，直到和右边一样
        int rhelp = lr;
        int chelp = lc;
        while (lc != rc){//先打印第一行，变的只有左列号
            System.out.println(arr[lr][lc++]);
        }
        while (lr != rr){//打印最右边一列，变的只有左行
            System.out.println(arr[lr++][rc]);
        }
        while (chelp != lc){//打印最下面一行，变的只有左列
            System.out.println(arr[rr][lc--]);
        }
        while (rhelp != lr){//打印最左边一列，变的只有左行号
            System.out.println(arr[lr--][lc]);
        }
        //这一圈已经打印完了，接下来递归的打印内圈
        rotateMatrix(arr, ++lr, ++lc, --rr, --rc);
    }

    /**
     * 旋转正方形矩阵
     * @param arr 目标矩阵
     * @param lr 左上角行号
     * @param lc 左上角列号
     * @param rr 右下角行号
     * @param rc 右下角列号
     */
    public static void rotateSquare(int[][] arr, int lr, int lc, int rr, int rc){
        //左边坐标超过了右边说明已经不用旋转了
        if(lr > rr || lc > rc){
            return;
        }
        int n = rr - lr;
        for (int i = 0; i < n; i++){
            swap(arr, lr, lc + i, lr + i, rc);//交换第一行和最右列
            swap(arr, lr, lc + i, rr, rc - i);//交换最右列和最下行，但注意最右列已经交换到第一行去了
            swap(arr, lr, lc + i, rr - i, lc);
        }
        //这时候外圈已经交换完毕
        rotateSquare(arr, ++lr, ++lc, --rr, --rc);
    }
    private static void swap(int[][] arr, int lr, int lc, int rr, int rc){
        int temp = arr[lr][lc];
        arr[lr][lc] = arr[rr][rc];
        arr[rr][rc] = temp;
    }
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        rotateSquare(arr, 0, 0, arr.length - 1, arr[0].length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
