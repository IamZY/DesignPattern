package com.ntuzy.singleton.type7;

import java.security.PrivateKey;

/**
 * 静态内部类
 * 保证类装载机制来保证初始化实例的时候只有一个线程
 * 静态内部类方式在Singleton类被装载是并不会立即实例化  类的静态属性只会在第一次加载类的是红初始化 JVM帮助我们保证线程安全
 */
public class SingletonTest07 {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);
        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());
    }

}


class Singleton {
    private Singleton() {

    }

    // 静态内部类 该类中有静态属性SingletonInstance
    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }

    // 提供静态的共有方法 直接返回SingletonInstance.INSTANCE
    public static Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}