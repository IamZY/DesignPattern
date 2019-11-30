package com.ntuzy.singleton.type6;

/**
 * 双重检查
 */
public class SingletonTest06 {
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

    private volatile static Singleton instance;


    // 加入双重检查的代码块 解决线程安全问题 解决懒加载的问题
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }

}