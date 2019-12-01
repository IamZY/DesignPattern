package com.ntuzy.factory.absfactory.pizzastore.pizza;

public class BJCheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("北京的奶酪Pizza 准备原材料");
    }
}
