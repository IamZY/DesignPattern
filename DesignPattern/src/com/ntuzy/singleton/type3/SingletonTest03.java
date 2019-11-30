package com.ntuzy.singleton.type3;

/**
 * 线程不安全
 * 但是只能在单线程的状态下使用
 * 在实际开发中不能使用
 */
public class SingletonTest03 {
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

    private static Singleton instance;


    // 提供一个静态的共有方法 当使用到该方法的时候 才去创建instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }

}