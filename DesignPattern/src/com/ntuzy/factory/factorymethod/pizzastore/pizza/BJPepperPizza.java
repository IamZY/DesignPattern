package com.ntuzy.factory.factorymethod.pizzastore.pizza;

public class BJPepperPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("北京的胡椒Pizza 准备原材料");
    }
}
