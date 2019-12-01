package com.ntuzy.factory.absfactory.pizzastore.order;

import com.ntuzy.factory.absfactory.pizzastore.pizza.BJCheesePizza;
import com.ntuzy.factory.absfactory.pizzastore.pizza.BJPepperPizza;
import com.ntuzy.factory.absfactory.pizzastore.pizza.Pizza;

// 工厂子类
public class BJFactory implements AbsFactory {
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        System.out.println("抽象工厂模式...");
        if (orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
            pizza.setName("北京奶酪口味");
        } else if (orderType.equals("pepper")) {
            pizza = new BJPepperPizza();
            pizza.setName("北京胡椒口味");
        }
        return pizza;
    }
}
