package com.ntuzy.factory.absfactory.pizzastore.pizza;

public class LDPepperPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("伦敦的胡椒Pizza 准备原材料");
    }
}
