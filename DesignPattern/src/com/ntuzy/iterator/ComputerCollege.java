package com.ntuzy.iterator;

import java.util.Iterator;

public class ComputerCollege implements College {

    Department[] departments;
    int numOfDepartments = 0; // 保存当前数组对象个数

    public ComputerCollege() {
        departments = new Department[5];
        addDepartment("Java","Java");
        addDepartment("Php","Php");
        addDepartment("大数据","大数据");
    }

    @Override
    public String getName() {
        return "计算机学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
//        departments = new Department[5];
        Department department = new Department(name, desc);
        departments[numOfDepartments] = department;
        numOfDepartments++;
    }

    @Override
    public Iterator createIterator() {
        return new ComputerCollegeIterator(departments);
    }
}
