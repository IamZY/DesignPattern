package com.ntuzy.singleton.type1;

public class SingletonTest01 {


    public static void main(String[] args){
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

    // 奔雷内部创建对象实例
    private final static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

    //


}
