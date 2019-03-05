package com.sucre.SwordOffer;

/**
 * 斐波那契数列
 */
public class Fibonacci {
    public int Fibonacci(int n) {
        if (n == 0 || n == 1) return n;
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}
