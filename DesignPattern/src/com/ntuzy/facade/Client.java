package com.ntuzy.facade;

public class Client {
    public static void main(String[] args){
        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();
        homeTheaterFacade.ready();
        homeTheaterFacade.play();
    }
}
