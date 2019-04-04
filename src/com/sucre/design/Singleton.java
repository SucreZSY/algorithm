package com.sucre.design;

public class Singleton {
    //饿汉式
    private static Singleton singleton;

    public static Singleton getSingleton(){
        if (singleton != null){
            return singleton;
        }
        return new Singleton();
    }
    private Singleton(){}//私有化构造
}
