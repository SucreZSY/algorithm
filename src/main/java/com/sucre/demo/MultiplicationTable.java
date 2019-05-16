package com.sucre.demo;

public class MultiplicationTable {
    /**
     * 打印n行的乘法口诀
     * @param n 行数
     */
    public static void print(int n){
        int i = 1;
        int j = 0;
        while(i <= n) {
            while (j++ < i) {
                System.out.print(j + " * " + i + " = " + i * j);
                System.out.print("\t");
            }
            System.out.println();
            j = 0;
            i++;
        }
    }

    public static void main(String[] args) {

    }
}
