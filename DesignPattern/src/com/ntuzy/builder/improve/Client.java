package com.ntuzy.builder.improve;

public class Client {
    public static void main(String[] args){
        // 盖普通房子
        CommonHouse commonHouse = new CommonHouse();
        // 准备创建房子的指挥者
        HouseDirector houseDirector = new HouseDirector(commonHouse);

        // 完成盖房子 返回商品
        House house = houseDirector.constructHouse();

        System.out.println(house);

//        System.out.println(house instanceof CommonHouse);
        
    }
}
