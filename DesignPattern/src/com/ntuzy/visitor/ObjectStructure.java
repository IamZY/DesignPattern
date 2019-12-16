package com.ntuzy.visitor;

import java.util.LinkedList;
import java.util.List;

public class ObjectStructure {

    // 维护一个集合
    private List<Person> persons = new LinkedList<>();

    // 增加到list
    public void attach(Person p) {
        persons.add(p);
    }

    public void detach(Person p) {
        persons.remove(p);
    }

    // 显示测评情况
    public void display(Action action) {
        for (Person p : persons) {
            p.accept(action);
        }
    }


}
