package com.ntuzy.iterator;

import java.util.Iterator;
import java.util.List;

public class OutPutImpl {

    List<College> collegeList;

    public OutPutImpl(List<College> collegeList) {
        this.collegeList = collegeList;
    }

    // 遍历所有学院
    public void printCollege() {
        // 首先取出 所有的学院
        Iterator<College> iterator = collegeList.iterator();
        while (iterator.hasNext()) {
            College next = iterator.next();
            System.out.println("=========" + next.getName() + "=============");
            printDepartments(next.createIterator());
        }
    }

    // 学院输出系
    public void printDepartments(Iterator iterator) {
        while (iterator.hasNext()) {
            Department next = (Department) iterator.next();
            System.out.println(next.getName());
        }
    }

}
