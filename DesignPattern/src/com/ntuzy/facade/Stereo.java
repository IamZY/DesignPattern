package com.ntuzy.facade;

public class Stereo {

    private static Stereo instance = new Stereo();

    public static Stereo getInstance() {
        return instance;
    }

    private Stereo() {

    }

    public void on() {
        System.out.println(" Stereo up ");
    }

    public void off() {
        System.out.println(" Stereo down ");
    }


    public void up() {
        System.out.println(" Stereo up ");
    }

    public void down() {
        System.out.println(" Stereo down ");
    }


}
