package com.sucre.demo;

import java.util.concurrent.Semaphore;

/**
 * 按顺序打印线程
 */
public class PrintThreadInOrder {
    private static Semaphore semaphoreA = new Semaphore(1);
    private static Semaphore semaphoreB = new Semaphore(0);
    private static Semaphore semaphoreC = new Semaphore(0);

    private static int n;

    public PrintThreadInOrder(int n) {
        PrintThreadInOrder.n = n;
    }

    public void printA(){
        int count = 0;
        while (count < n){
            try {
                semaphoreA.acquire();
                System.out.println("ThreadA: printA");
                semaphoreB.release();
                count++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void printB(){
        int count = 0;
        while (count < n){
            try {
                semaphoreB.acquire();
                System.out.println("ThreadB: printB");
                semaphoreC.release();
                count++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void printC(){
        int count = 0;
        while (count < n){
            try {
                semaphoreC.acquire();
                System.out.println("ThreadC: printC");
                semaphoreA.release();
                count++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        PrintThreadInOrder demo = new PrintThreadInOrder(1);
        new Thread(demo::printA).start();
        new Thread(demo::printB).start();
        new Thread(demo::printC).start();
    }
}
