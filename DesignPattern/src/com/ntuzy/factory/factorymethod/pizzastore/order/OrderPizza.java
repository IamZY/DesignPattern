package com.ntuzy.factory.factorymethod.pizzastore.order;

import com.ntuzy.factory.factorymethod.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class OrderPizza {
    // 构造器
    public OrderPizza() {
        Pizza pizza = null;
        String orderType = "";

        do {
            orderType = getType();
            pizza = createPizza(orderType);  // 抽象的方法  由工厂子类完成

            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();

        } while (true);

    }


    // 定义一个抽象方法 createPizza 让各个工厂子类自己实现
    abstract Pizza createPizza(String orderType);


    // 写一个方法 可以获取客户希望订购Pizza种类
    private String getType() {
        try {
            BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza 种类:");
            String str = strin.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }


}
