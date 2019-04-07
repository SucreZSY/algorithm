package com.sucre.algorithm.hash;

/**
 * 岛问题，引出并查集来解决分布式岛的问题
 */
public class Island {
    /**
     * 岛问题，连成一片的1称为一个岛
     * @param arr 目标矩阵
     * @return 到的数量
     */
    public static int island(int[][] arr){
        //基本思路，循环遍历数组，只要遇到一个1，就把岛的数量加1，就开始启动感染函数，把周围所有的1都感染成2
        int R = arr.length;
        int C = arr[0].length;
        int sum = 0;

        for (int i = 0; i < R; i++){
            for (int j = 0; j < C; j++){
                if (arr[i][j] == 1){
                    sum++;
                    infect(arr, i, j, R, C);
                }
            }
        }
        return sum;
    }

    /**
     * 感染函数，将这个坐标以及他周围所有的1都感染成2
     * @param arr 目标矩阵
     * @param r 行号
     * @param c 列号
     * @param R 总行号
     * @param C 总列号
     */
    public static void infect(int[][] arr, int r, int c, int R, int C){
        if (r < 0 || r >= R || c < 0 || c >= C || arr[r][c] == 0 || arr[r][c] == 2){
            return;
        }
        arr[r][c] = 2;
        //递归感染这个坐标的上下左右四个方向
        infect(arr, r - 1, c, R, C);
        infect(arr, r + 1, c, R, C);
        infect(arr, r, c - 1, R, C);
        infect(arr, r, c + 1, R, C);
    }

    public static void main(String[] args) {
        int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(island(m1));

        int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(island(m2));
    }
}
