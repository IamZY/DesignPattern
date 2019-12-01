package com.ntuzy.factory.factorymethod.pizzastore.pizza;

import java.util.stream.StreamSupport;

public class BJCheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("北京的奶酪Pizza 准备原材料");
    }
}
