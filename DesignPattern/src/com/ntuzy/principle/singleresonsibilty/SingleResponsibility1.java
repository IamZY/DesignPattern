package com.ntuzy.principle.singleresonsibilty;

import com.sun.jmx.snmp.agent.SnmpMibOid;

public class SingleResponsibility1 {


    public static void main(String[] args){
        Vehicle vehicle = new Vehicle();
        vehicle.run("摩托车");
        vehicle.run("汽车");
        vehicle.run("飞机");
    }

}


// 交通工具类
// 方式1
// 在方法1中违反了单一职责原则  根据交通工具运行方式的不同 创建新的类
class Vehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在公路上跑");
    }
}
