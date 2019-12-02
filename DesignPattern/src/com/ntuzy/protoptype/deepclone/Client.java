package com.ntuzy.protoptype.deepclone;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        DeepProtoType p = new DeepProtoType();
        p.name = "松江";
        p.deepCloneableTarget = new DeepCloneableTarget("大牛", "大牛的类");

        // 方式1 进行深拷贝
        //DeepProtoType p2 = (DeepProtoType) p.clone();
        //System.out.println(p);
        //System.out.println(p2);


        DeepProtoType p2 = (DeepProtoType) p.deepClone();
        System.out.println(p);
        System.out.println(p2);

    }
}
