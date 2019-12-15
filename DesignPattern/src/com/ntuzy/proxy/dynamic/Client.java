package com.ntuzy.proxy.dynamic;

public class Client {
    public static void main(String[] args) {
        // 创建目标对象
        TeacherDao target = new TeacherDao();

        // 给目标对象创建代理对象 可以强转成ITeacherDao
        ITeacherDao proxyInstance = (ITeacherDao) new ProxyFactory(target).getProxyInstance();

        proxyInstance.teach();
        proxyInstance.sayHello("tom");
        System.out.println(proxyInstance.getClass());
    }
}
