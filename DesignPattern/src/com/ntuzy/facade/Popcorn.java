package com.ntuzy.facade;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Popcorn {

    private static Popcorn instance = new Popcorn();

    public static Popcorn getInstance() {
        return instance;
    }

    private Popcorn() {

    }

    public void on() {
        System.out.println(" popcorn on ");
    }
    
    public void off() {
        System.out.println(" popcorn on ");
    }
    
    public void pop() {
        System.out.println(" popcorn pop ");
    }


}
