package com.ntuzy.factory.simplefactory.pizzastore.pizza;

public class PepperPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("给胡椒Pizza准备原材料");
    }
}
