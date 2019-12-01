package com.ntuzy.factory.absfactory.pizzastore.order;

import com.ntuzy.factory.absfactory.pizzastore.pizza.*;

public class LDFactory implements AbsFactory {
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new LDCheesePizza();
            pizza.setName("伦敦奶酪口味");
        } else if (orderType.equals("pepper")) {
            pizza = new LDPepperPizza();
            pizza.setName("伦敦胡椒口味");
        }
        return pizza;
    }
}
