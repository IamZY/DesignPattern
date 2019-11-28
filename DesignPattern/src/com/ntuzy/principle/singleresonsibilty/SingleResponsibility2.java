package com.ntuzy.principle.singleresonsibilty;

public class SingleResponsibility2 {


    public static void main(String[] args){
        RoadVehicle roadVehicle = new RoadVehicle();
        roadVehicle.run("摩托车");
        roadVehicle.run("汽车");


        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("飞机");
    }

}


// 交通工具类

// 遵守单一职责原则
// 但是这样做的改动很大 将职责分解 同时修改客户端
class RoadVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在公路上跑");
    }
}

class AirVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在天空运行");
    }
}

class WaterVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在水中运行");
    }
}


