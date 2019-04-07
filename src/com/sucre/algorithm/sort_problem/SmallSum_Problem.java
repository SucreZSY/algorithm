package com.sucre.algorithm.sort_problem;

/**
 * 为了加深对归并的理解，这里的归并排序重新写一遍
 */
public class SmallSum_Problem {
    /**
     * 获取数组小和的方法，其实是归并排序
     * @param target 目标数组
     * @param left 求小和的范围左边界
     * @param right  右边界
     * @return 返回小和
     */
    public static int smallSum(int[] target, int left, int right){
        if (target == null || target.length < 2 || left == right) return 0;//只有一个数不产生小和
        int mid = left + ((right - left) >> 1);
        int resultL = smallSum(target, left, mid);
        int resultR = smallSum(target, mid + 1, right);
        int resultM = merge(target, left, mid, mid + 1, right);
        return resultL + resultR + resultM;
    }

    /**
     * 求两个有序数组左边数组和右边数组比较会产生多少小和，每个数组本身不比较
     * @param target 目标数组
     * @param indexLL 左数组的左边界
     * @param indexLR 左数组右边界
     * @param indexRL 右数组左边界
     * @param indexRR 右数组右边界
     * @return 返回这个两个数组比较之后的小和
     */
    @SuppressWarnings("all")
    public static int merge(int[] target, int indexLL, int indexLR, int indexRL, int indexRR){
        if (indexLL == indexRL) return 0;
        int indexL = indexLL;
        int indexR = indexRL;
        int indexI = 0;
        int[] help = new int[(indexLR - indexLL + 1) + (indexRR - indexRL +1)];
        int result = 0;//小和

        while (indexL <= indexLR && indexR <= indexRR){
            result += target[indexL] < target[indexR] ? ((indexRR - indexR +1) * target[indexL]) : 0;
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
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,2,5};
        System.out.println(smallSum(arr, 0, arr.length - 1));
    }
}
