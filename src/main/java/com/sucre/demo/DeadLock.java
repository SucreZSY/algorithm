package com.sucre.demo;

/**
 * 死锁模型
 */
public class DeadLock {
    private static Object locka = new Object();
    private static Object lockb = new Object();

    public static void functionA(){
        synchronized (locka){
            try {
                Thread.sleep(2000);
            }catch (Exception e){

            }
            synchronized (lockb){
                functionB();
            }
        }
    }

    public static void functionB(){
        synchronized (lockb){
            try {
                Thread.sleep(2000);
            }catch (Exception e){

            }
            synchronized (locka){
                System.out.println("functionB");
            }
        }
    }

    public static void main(String[] args) {
        new Thread(DeadLock::functionA).start();//由于synchronized是可重入锁，如果没有另一个线程启动的话，即使方法a中继续调用了方法b，也是不会出现死锁的
        new Thread(DeadLock::functionB).start();
    }
}
