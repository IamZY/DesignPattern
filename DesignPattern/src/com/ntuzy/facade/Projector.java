package com.ntuzy.facade;

public class Projector {

    private static Projector instance = new Projector();

    public static Projector getInstance() {
        return instance;
    }

    private Projector() {

    }

    public void on() {
        System.out.println(" projector on ");
    }

    public void off() {
        System.out.println(" projector on ");
    }


    public void focus() {
        System.out.println(" projector focus ");
    }


}
