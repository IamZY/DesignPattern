package com.ntuzy.memento.game;

public class Client {

    public static void main(String[] args){
        GameRole gameRole = new GameRole();
        gameRole.setVit(100);
        gameRole.setDef(100);

        gameRole.display();


        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(gameRole.createMemento());

        gameRole.setVit(30);
        gameRole.setDef(30);

        gameRole.display();

        gameRole.recoverGameRoleFromMemento(caretaker.getMemento());

        gameRole.display();

    }
}
