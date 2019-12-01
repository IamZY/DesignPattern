package com.ntuzy.factory.simplefactory.pizzastore.pizza;

public class GreekPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("给希腊Pizza准备原材料");
    }
}
