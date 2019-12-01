package com.ntuzy.factory.simplefactory.pizzastore.order;

import com.ntuzy.factory.simplefactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza2 {

    private Pizza pizza = null;
    private String orderType = "";

    public OrderPizza2() {

        do {
            orderType = getType();
            pizza = SimpleFactory.createPizza2(orderType);
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
