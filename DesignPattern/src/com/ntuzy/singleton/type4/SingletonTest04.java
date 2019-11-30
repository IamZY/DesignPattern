package com.ntuzy.singleton.type4;

/**
 * 不推荐 效率低
 */
public class SingletonTest04 {
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
    // 加入同步处理的代码块 解决线程安全问题
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }

}