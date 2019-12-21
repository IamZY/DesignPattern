package com.ntuzy.visitor;


import javax.tools.JavaCompiler;

public abstract class Person {

    // 提供一个方法 让访问者可以访问
    public abstract void accept(Action action);

    public Person() {
//        new java.util.Map<>().
    }

}
