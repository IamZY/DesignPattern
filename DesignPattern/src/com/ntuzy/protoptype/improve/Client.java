package com.ntuzy.protoptype.improve;

public class Client {
    public static void main(String[] args) {
        Sheep sheep = new Sheep("tom", 1, "白色");

        sheep.setFriend(new Sheep("jack", 2, "黑色"));


        Sheep sheep2 = (Sheep) sheep.clone();
        Sheep sheep3 = (Sheep) sheep.clone();
        Sheep sheep4 = (Sheep) sheep.clone();
        Sheep sheep5 = (Sheep) sheep.clone();

        System.out.println(sheep + "--" + sheep.getFriend());
        System.out.println(sheep2 + "--" + sheep2.getFriend());

    }
}
