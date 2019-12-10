package com.ntuzy.flyweight;

public class ConcreteWebSite extends WebSite {

    // 共享 内部状态
    String type = "";   // 网站发布的类型

    public ConcreteWebSite(String type) {
        this.type = type;
    }

    @Override
    public void use(User user) {
        // 
        System.out.println("网站的发布形式为" + type + ",使用者是" + user.getName());


    }
}
