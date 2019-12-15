package com.ntuzy.proxy.cglib;

public class Client {
    public static void main(String[] args){
        // 创建目标对象
        TeacherDao target = new TeacherDao();

        // 获取到代理对象 并且将目标对象传递给代理对象
        TeacherDao proxyInstance = (TeacherDao) new ProxyFactory(target).getProxyInstance();

        proxyInstance.teach();
    }
}
