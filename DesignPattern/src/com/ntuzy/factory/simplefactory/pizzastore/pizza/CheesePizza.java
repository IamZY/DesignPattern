package com.ntuzy.factory.simplefactory.pizzastore.pizza;

public class CheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("给制作奶酪Pizza 准备原材料");
    }
}
