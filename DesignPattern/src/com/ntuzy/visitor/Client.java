package com.ntuzy.visitor;

import java.util.Vector;

public class Client {
    public static void main(String[] args){
        // 创建ObjectStructure
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.attach(new Man());
        objectStructure.attach(new Woman());

        // 成功
        Success success = new Success();
        objectStructure.display(success);

        Fail fail = new Fail();
        objectStructure.display(fail);

//        Vector

    }
}
