package com.sucre.leetcode;

/**
 * 3个可乐盖子换一瓶可乐，求买n瓶可乐能喝到多少瓶可乐
 */
public class Cocacola {
    /**
     * 买n瓶可乐能喝到多少瓶，3个盖换一瓶新的
     * @param n n瓶可乐
     * @return 最终喝到的可乐
     */
    public static int cola(int n){
        return (n < 3) ? n : n + cap(n);//不足三瓶直接返回，否则继续将瓶盖换可乐
    }


    /**
     * 单纯的瓶盖能换到多少瓶可乐
     * @param n 瓶盖数量
     * @return 总共能换的可乐数量
     */
    public static int cap(int n){
        if (n < 3) return 0;
        int sum = n / 3;
        sum += cap(n / 3 + n % 3);
        return sum;
    }

    /**
     * 把瓶盖换成可乐，包括上次未换完的
     * @param capnum 瓶盖总数量
     * @param colanum 目前已经喝了的可乐数量
     * @return 包括刚开始喝掉的可乐的总数量
     */
    public static int cap(int capnum, int colanum){
        colanum += (capnum < 3) ? 0 : capnum / 3;//不足3个瓶盖换不了可乐
        return (capnum < 3) ? colanum : cap(capnum / 3 + capnum % 3, colanum);
    }
    public static void main(String[] args) {
        System.out.println(cola(3));
    }
}
