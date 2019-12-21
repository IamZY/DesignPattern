package com.ntuzy.memento.game;

public class GameRole {
    private int vit;
    private int def;

    public Memento createMemento() {
        return new Memento(vit, def);
    }

    // 从备忘录对象恢复对象
    public void recoverGameRoleFromMemento(Memento memento) {
        this.vit = memento.getVit();
        this.def = memento.getDef();
    }

    public void display() {
        System.out.println("vit = " + this.vit + ", def = " + this.def);
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }
}
