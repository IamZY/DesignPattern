package com.ntuzy.starategy;

public class Client {
    public static void main(String[] args){

        Context context = new Context(new OperationAdd());
        int add = context.executeStrategy(1, 5);
        System.out.println("1 + 5 = " + add);
        context = new Context(new OperationSub());
        int sub = context.executeStrategy(1,5);
        System.out.println("1 - 5 = " + sub);

    }
}
