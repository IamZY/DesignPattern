package com.ntuzy.memento;

public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState(" state#1 ");
        // 保存当前状态
        caretaker.add(originator.saveStateMemento());

        // 恢复状态
        originator.getStateFromMemento(caretaker.get(0));
        System.out.println(originator.getState());

    }
}
