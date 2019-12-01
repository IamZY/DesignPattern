package com.ntuzy.factory.absfactory.pizzastore.order;

import com.ntuzy.factory.absfactory.pizzastore.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {

    private AbsFactory absFactory;

    private void setAbsFactory(AbsFactory absFactory) {
        Pizza pizza = null;
        String orderType = "";
        this.absFactory = absFactory;

        do {
            orderType = getType();
            pizza = absFactory.createPizza(orderType);

            if (pizza != null) {
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

    public OrderPizza (AbsFactory absFactory) {
        setAbsFactory(absFactory);
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
