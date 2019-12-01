package com.ntuzy.factory.factorymethod.pizzastore.order;

import com.ntuzy.factory.factorymethod.pizzastore.pizza.*;

public class LDOrderPizza extends OrderPizza {
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;

        if (orderType.equals("cheese")) {
            pizza = new LDCheesePizza();
            pizza.setName("伦敦的奶酪Pizza");
        } else if (orderType.equals("pepper")) {
            pizza = new LDPepperPizza();
            pizza.setName("伦敦的胡椒Pizza");
        }

        return pizza;
    }
}
