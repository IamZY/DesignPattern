package com.ntuzy.facade;

public class Screen {

    private static Screen instance = new Screen();

    public static Screen getInstance() {
        return instance;
    }

    private Screen() {

    }

    public void up() {
        System.out.println(" screen up ");
    }

    public void down() {
        System.out.println(" screen down ");
    }


    public void focus() {
        System.out.println(" projector focus ");
    }

}
