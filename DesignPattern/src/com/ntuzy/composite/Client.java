package com.ntuzy.composite;

public class Client {
    public static void main(String[] args){
        // 从大到小创建对象
        OrganizationComponent university = new University("清华大学", "中国顶级大学");

        //
        OrganizationComponent college1 = new College("计算机学院", "计算机学院");
        OrganizationComponent college2 = new College("信息工程学院", "信息工程学院");


        // 创建各个学院下面的系
        college1.add(new Department("软件工程","软件工程"));
        college1.add(new Department("网络工程","网络工程"));
        college1.add(new Department("计算机科学与技术","计算机科学与技术"));

        //
        college2.add(new Department("通信工程","通信工程"));
        college2.add(new Department("信息工程","信息工程"));

        university.add(college1);
        university.add(college2);

        university.print();
        college1.print();
        college2.print();
    }
}
