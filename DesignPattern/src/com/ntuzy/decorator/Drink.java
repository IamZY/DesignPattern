package com.ntuzy.decorator;

public abstract class Drink {

    public String des;
    public float price = 0.0f;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    // 计算费用得抽象方法
    public abstract float cost();

}
