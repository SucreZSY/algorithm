package com.sucre.algorithm.sort_problem;

/**
 * 依然是利用归并排序来打印逆序对
 */
public class ReverseOrder_Problem {
    /**
     * 获取数组逆序对的方法，其实是归并排序
     * @param target 目标数组
     * @param left 求小和的范围左边界
     * @param right  右边界
     */
    public static void reverseOrder(int[] target, int left, int right){
        if (target == null || target.length < 2 || left == right) return ;//只有一个数不产生小和
        int mid = left + ((right - left) >> 1);
        reverseOrder(target, left, mid);
        reverseOrder(target, mid + 1, right);
        merge(target, left, mid, mid + 1, right);
    }

    /**
     * 求两个有序数组左边数组和右边数组比较会产生多少逆序对，每个数组本身不比较
     * @param target 目标数组
     * @param indexLL 左数组的左边界
     * @param indexLR 左数组右边界
     * @param indexRL 右数组左边界
     * @param indexRR 右数组右边界
     */
    @SuppressWarnings("all")
    public static void merge(int[] target, int indexLL, int indexLR, int indexRL, int indexRR){
        if (indexLL == indexRL) return ;
        int indexL = indexLL;
        int indexR = indexRL;
        int indexI = 0;
        int i = 0;
        int[] help = new int[(indexLR - indexLL + 1) + (indexRR - indexRL +1)];

        while (indexL <= indexLR && indexR <= indexRR){
            if (target[indexL] > target[indexR]){//当左边left比右边right大的时候，说明left以后所有的数都能与right构成逆序，循环打印
                for (i = indexL; i <= indexLR; i++){
                    System.out.println("逆序对：【" + target[i] + "," + target[indexR] + "]");
                }
            }
            help[indexI++] = (target[indexL] <= target[indexR]) ?  target[indexL++] : target[indexR++];
        }
        while (indexL <= indexLR){
            help[indexI++] = target[indexL++];
        }
        while (indexR <= indexRR){
            help[indexI++] = target[indexR++];
        }
        indexI = 0;
        //由于使用过程中两个数组肯定是连续的，这里就不麻烦考虑不连续的那种了
        for ( ; indexI < help.length; indexI++){
            target[indexLL++] = help[indexI];
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,1,0};
        reverseOrder(arr,0,arr.length-1);
    }
}
