package com.ntuzy.factory.simplefactory.pizzastore.order;

import com.ntuzy.factory.simplefactory.pizzastore.pizza.CheesePizza;
import com.ntuzy.factory.simplefactory.pizzastore.pizza.GreekPizza;
import com.ntuzy.factory.simplefactory.pizzastore.pizza.PepperPizza;
import com.ntuzy.factory.simplefactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {
    // 构造器
//    public OrderPizza() {
//        Pizza pizza = null;
//        String orderType; // 订购Pizza类型
//        do {
//            orderType = getType();
//            if (orderType.equals("greek")) {
//                pizza = new GreekPizza();
//                pizza.setName("希腊Pizza");
//            } else if (orderType.equals("cheese")) {
//                pizza = new CheesePizza();
//                pizza.setName("奶酪Pizza");
//            } else if (orderType.equals("pepper")) {
//                pizza = new PepperPizza();
//                pizza.setName("胡椒Pizza");
//            } else {
//                break;
//            }
//
//            // 输出pizza 制作过程
//            pizza.prepare();
//            pizza.bake();
//            pizza.cut();
//            pizza.box();
//
//        } while (true);
//    }

    // 定义简单工厂对象
    SimpleFactory simpleFactory;
    Pizza pizza = null;

    // 构造器
    public OrderPizza(SimpleFactory simpleFactory) {
        setFactory(simpleFactory);
    }

    public void setFactory(SimpleFactory simpleFactory) {
        String orderType = ""; // 用户输入
        this.simpleFactory = simpleFactory;  // 设置一个工厂对象

        do {
            orderType = getType();
            pizza = this.simpleFactory.createPizza(orderType);
            // 输出pizza一些信息
            if (pizza != null) {
                // 订购成功
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println("订购失败");
                break;
            }
        } while (true);

    }


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
