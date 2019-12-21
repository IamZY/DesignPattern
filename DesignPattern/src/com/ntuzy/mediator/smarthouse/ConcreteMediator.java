package com.ntuzy.mediator.smarthouse;

import java.util.HashMap;

// 具体的中介者类
public class ConcreteMediator extends Mediator {
    // 集合
    private HashMap<String, Colleague> colleagueMap;
    private HashMap<String, String> interMap;

    public ConcreteMediator() {
        colleagueMap = new HashMap<String, Colleague>();
        interMap = new HashMap<String, String>();
    }

    @Override
    public void Register(String colleagueName, Colleague colleague) {
        // TODO Auto-generated method stub
        colleagueMap.put(colleagueName, colleague);

        // TODO Auto-generated method stub

        if (colleague instanceof Alarm) {
            interMap.put("Alarm", colleagueName);
        } else if (colleague instanceof CoffeeMachine) {
            interMap.put("CoffeeMachine", colleagueName);
        } else if (colleague instanceof TV) {
            interMap.put("TV", colleagueName);
        } else if (colleague instanceof Curtains) {
            interMap.put("Curtains", colleagueName);
        }

    }

    // 具体中介者的核心方法
    // 根据得到的消息完成对应任务
    // 中介者在这个方法 协调各个具体的同事对象 完成任务
    @Override
    public void GetMessage(int stateChange, String colleagueName) {
        // TODO Auto-generated method stub

        //
        if (colleagueMap.get(colleagueName) instanceof Alarm) {
            if (stateChange == 0) {
                ((CoffeeMachine) (colleagueMap.get(interMap
                        .get("CoffeeMachine")))).StartCoffee();
                ((TV) (colleagueMap.get(interMap.get("TV")))).StartTv();
            } else if (stateChange == 1) {
                ((TV) (colleagueMap.get(interMap.get("TV")))).StopTv();
            }

        } else if (colleagueMap.get(colleagueName) instanceof CoffeeMachine) {
            ((Curtains) (colleagueMap.get(interMap.get("Curtains"))))
                    .UpCurtains();

        } else if (colleagueMap.get(colleagueName) instanceof TV) {

        } else if (colleagueMap.get(colleagueName) instanceof Curtains) {
            // 如果是窗帘发出的消息在这里使用
        }

    }

    @Override
    public void SendMessage() {
        // TODO Auto-generated method stub

    }

}
