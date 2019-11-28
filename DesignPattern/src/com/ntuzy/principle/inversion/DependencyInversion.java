package com.ntuzy.principle.inversion;

public class DependencyInversion {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
    }
}


class Email {
    public String getInfo() {
        return "电子邮件信息: hello world";
    }
}

// 完成Person接受消息的功能
// 方式1
// 容易实现
// 如果我们获取的对象是微信或者是短信等等 则新增类 同时Person也要增加相应的接受方法
// 引入一个抽象的接口IReceiver 表示接收者 这样Person类与这个接口IReceiver发生依赖
// 因为Email WeiXin 等等属于接受的范围 他们各自实现IReceiver
class Person {
    public void receive(Email email) {
        System.out.println(email.getInfo());
    }
}
