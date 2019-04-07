package com.sucre.algorithm.array_links;

/**
 * 在行列都排好序的矩阵中找数，注意一定要从左下或者右上找，使两个方向数字大小规律相反
 */
public class FindNumInSortedMartrix {
    /**
     * 在行列都排好序的矩阵中查找数
     * @param arr 目标数组
     * @param num 目标数
     * @return 是否存在这一个数
     */
    public static boolean findNumInMartrix(int[][] arr, int num){
        //必须从左下角或者右上角来开始查找，因为可以判断下一次的方向，往两边移动分别是递增和递减
        //如果是左上角就无法判断了，两边都是递增，找一个比顶点大的数的话就不知道该向下还是向上移动
        if (arr == null) throw new RuntimeException("error");

        int row = arr.length - 1;
        int col = 0;
        while (row > -1 && col < arr[0].length){
            if (arr[row][col] == num) return true;
            if (arr[row][col] > num){
                row--;
            }else {
                col++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 0, 1, 2, 3, 4, 5, 6 },// 0
                { 10, 12, 13, 15, 16, 17, 18 },// 1
                { 23, 24, 25, 26, 27, 28, 29 },// 2
                { 44, 45, 46, 47, 48, 49, 50 },// 3
                { 65, 66, 67, 68, 69, 70, 71 },// 4
                { 96, 97, 98, 99, 100, 111, 122 },// 5
                { 166, 176, 186, 187, 190, 233, 234 },// 6
                { 237, 243, 321, 341, 356, 370, 380 } // 7
        };
        int K = 233;
        System.out.println(findNumInMartrix(matrix, K));
    }
}
