package com.ntuzy.factory.simplefactory.pizzastore.order;

import com.ntuzy.factory.simplefactory.pizzastore.pizza.CheesePizza;
import com.ntuzy.factory.simplefactory.pizzastore.pizza.GreekPizza;
import com.ntuzy.factory.simplefactory.pizzastore.pizza.PepperPizza;
import com.ntuzy.factory.simplefactory.pizzastore.pizza.Pizza;

// 简单工厂类
public class SimpleFactory {


    // 根据type 返回Pizza对象
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        System.out.println("使用简单工厂模式");
        if (orderType.equals("greek")) {
            pizza = new GreekPizza();
            pizza.setName("希腊Pizza");
        } else if (orderType.equals("cheese")) {
            pizza = new CheesePizza();
            pizza.setName("奶酪Pizza");
        } else if (orderType.equals("pepper")) {
            pizza = new PepperPizza();
            pizza.setName("胡椒Pizza");
        }

        return pizza;
    }

    // 简单工厂模式 也将静态工厂模式
    public static Pizza createPizza2(String orderType) {
        Pizza pizza = null;
        System.out.println("使用简单工厂模式");
        if (orderType.equals("greek")) {
            pizza = new GreekPizza();
            pizza.setName("希腊Pizza");
        } else if (orderType.equals("cheese")) {
            pizza = new CheesePizza();
            pizza.setName("奶酪Pizza");
        } else if (orderType.equals("pepper")) {
            pizza = new PepperPizza();
            pizza.setName("胡椒Pizza");
        }

        return pizza;
    }
}
