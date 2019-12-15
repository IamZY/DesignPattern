package com.ntuzy.command;

public class Client {
    public static void main(String[] args) {
        // 使用命令设计模式 完成通过遥控器对电灯的操作

        // 创建电灯对象
        LightReceiver lightReceiver = new LightReceiver();

        // 创建电灯相关开关命令
        LightOnCommand lightOnCommand = new LightOnCommand(lightReceiver);
        LightOffCommand lightOffCommand = new LightOffCommand(lightReceiver);


        // 遥控器
        RemoteController remoteController = new RemoteController();

        // 给遥控器设置相关命令
        remoteController.setCommand(0, lightOnCommand, lightOffCommand);

        System.out.println("----------------------------------------------");
        remoteController.onButtonWasPushed(0);

        remoteController.offButtonWasPushed(0);

    }
}
