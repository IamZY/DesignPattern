package com.ntuzy.decorator;

public class CoffeeBar {
    public static void main(String[] args){

        // 装饰者模式下的订单  2份巧克力+一份牛奶的LongBlack

        // 1 点一份LongBlack
        Drink order = new LongBlack();
        //
        order = new Milk(order);
        order = new Soy(order);
        
        System.out.println(order.getDes() + "--" + order.cost());
    }

}
