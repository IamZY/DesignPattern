package com.ntuzy.singleton.type2;

public class SingletonTest02 {


    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);
        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());
    }

}


class Singleton {
    // 构造器私有化
    private Singleton() {
    }

    static {
        // 在静态代码块中创建单例对象
        instance = new Singleton();
    }


    // 奔雷内部创建对象实例
    private static Singleton instance;

    public static Singleton getInstance() {
        return instance;
    }

    //


}
