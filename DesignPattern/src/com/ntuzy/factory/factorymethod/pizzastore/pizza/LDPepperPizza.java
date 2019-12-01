package com.ntuzy.factory.factorymethod.pizzastore.pizza;

public class LDPepperPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("伦敦的胡椒Pizza 准备原材料");
    }
}
