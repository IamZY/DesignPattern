package com.ntuzy.facade;

public class TheaherLight {

    private static TheaherLight instance = new TheaherLight();

    public static TheaherLight getInstance() {
        return instance;
    }

    private TheaherLight() {

    }

    public void on() {
        System.out.println(" TheaherLight up ");
    }

    public void off() {
        System.out.println(" TheaherLight down ");
    }


    public void dim() {
        System.out.println(" TheaherLight up ");
    }

    public void bright() {
        System.out.println(" TheaherLight down ");
    }

}
