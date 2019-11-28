package com.ntuzy.principle.singleresonsibilty;

public class SingleResponsibility3 {


    public static void main(String[] args){
        Vehicle2 vehicle2 = new Vehicle2();
        vehicle2.run("摩托车");
        vehicle2.run("汽车");
        vehicle2.runAir("飞机");

    }

}

//
// 交通工具类
// 方式3
// 没有在类这个级别上遵守单一指责原则 但是在方法级别上
class Vehicle2 {
    public void run(String vehicle) {
        System.out.println(vehicle + "在公路上跑");
    }


    public void runAir(String vehicle) {
        System.out.println(vehicle + "在天上上跑");

    }

    public void runWater(String vehicle) {
        System.out.println(vehicle + "在水上跑");
    }

}



