package com.ntuzy.factory.factorymethod.pizzastore.order;

import com.ntuzy.factory.factorymethod.pizzastore.pizza.BJCheesePizza;
import com.ntuzy.factory.factorymethod.pizzastore.pizza.BJPepperPizza;
import com.ntuzy.factory.factorymethod.pizzastore.pizza.Pizza;

public class BJOrderPizza extends OrderPizza {
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null;

        if (orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
            pizza.setName("北京的奶酪口味");
        } else if (orderType.equals("pepper")) {
            pizza = new BJPepperPizza();
            pizza.setName("北京的胡椒口味");
        }

        return pizza;
    }
}
