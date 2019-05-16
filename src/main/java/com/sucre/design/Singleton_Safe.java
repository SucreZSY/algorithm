package com.sucre.design;

/**
 * 线程安全的懒汉式
 */
public class Singleton_Safe {

    private static volatile Singleton_Safe singleton;//加上volatile的原因这里只有一点：防止系统将代码重排序
    //volatile有两个作用，1.保证变量可见性，读取变量都会从主内存中读取，
    //      然后修改了就会写回主内存，这一点synchronized和lock都能保证
    //                  2.保证有序性

    public static Singleton_Safe getSingleton() {
        if (singleton == null) {//优化效率，只有为空的情况才会走同步代码块
            synchronized (Singleton_Safe.class) {
                if (singleton == null) {//保证singleton是真的为null，因为可能有几个线程同时走到了if内，只不过是阻塞状态，如果不加这个判断的话，
                    // 这个线程结束后那几个阻塞的线程就会创建几个新的对象出来
                    singleton = new Singleton_Safe();
                }
            }
        }
        return singleton;
    }

    private Singleton_Safe() {}
}

class Singleton_Safe_2{
    private static class StaticInstance{
        private static final Singleton_Safe_2 singleton = new Singleton_Safe_2();
    }
    public static Singleton_Safe_2 getInstance(){
        return StaticInstance.singleton;
    }
}
enum Singleton_Safe_3 {
    SINGLETON_SAFE_3;
}