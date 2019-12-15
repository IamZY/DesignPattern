package com.ntuzy.template;

public abstract class SoyaMilk {


    // 模板方法 make 模板方法可以做成final  不让子类覆盖
    final void make() {
        select();
        addCondiments();
        soak();
        beat();
    }

    void select() {
        System.out.println("选择好的新鲜的黄豆");
    }

    // 添加不同的配料
    abstract void addCondiments();


    // 浸泡
    void soak() {
        System.out.println("黄豆配料开始浸泡，需要三小时");
    }

    void beat() {
        System.out.println("黄豆配料放到豆浆机打碎");
    }



}
