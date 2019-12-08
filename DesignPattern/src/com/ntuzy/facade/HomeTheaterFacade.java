package com.ntuzy.facade;

public class HomeTheaterFacade {

    // 定义各个子系统的对象
    private TheaherLight theaherLight;
    private Popcorn popcorn;
    private Stereo stereo;
    private Projector projector;
    private Screen screen;
    private DVDPlayer dvdPlayer;


    public HomeTheaterFacade() {
        this.theaherLight = TheaherLight.getInstance();
        this.popcorn = Popcorn.getInstance();
        this.stereo = Stereo.getInstance();
        this.projector = Projector.getInstance();
        this.screen = Screen.getInstance();
        this.dvdPlayer = DVDPlayer.getInstance();
    }

    public void ready() {
        popcorn.on();
        popcorn.pop();
        screen.down();
        projector.on();
        stereo.on();
        dvdPlayer.on();
        theaherLight.dim();
    }

    public void play() {
        dvdPlayer.play();
    }

    public void pause() {
        dvdPlayer.pause();
    }

    public void end() {
        popcorn.off();
        theaherLight.bright();
        screen.up();
        projector.off();
        stereo.off();
        dvdPlayer.off();
    }


    public static void main(String[] args) {

    }
}
