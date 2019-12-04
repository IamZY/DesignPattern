package com.ntuzy.decorator;

public class Decorator extends Drink {
    private Drink obj;

    public Decorator(Drink drink) {
        this.obj = drink;
    }

    @Override
    public float cost() {
        //getPrice 自己的价格
        return super.getPrice() + obj.cost();
    }

    @Override
    public String getDes() {
        // obj.getDes() 输出被装饰者的信息
        return super.getDes() + " " + super.getPrice() + "&&" + obj.getDes();
    }
}
