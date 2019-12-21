package com.ntuzy.memento.game;

import java.util.ArrayList;
import java.util.HashMap;

// 守护者对象 保存游戏角色的状态
public class Caretaker {
    private Memento memento;

    // 对GameRole 保存很多次的状态
//    private ArrayList<Memento> mementos;
    // 多个游戏角色有多个状态
//    private HashMap<String,ArrayList<Memento>> roleMementos = new HashMap<>();


    public Caretaker() {
    }

    public Caretaker(Memento memento) {
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
