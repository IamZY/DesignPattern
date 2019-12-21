package com.ntuzy.observer;


import java.util.ArrayList;

public class WeatherData implements Subject {
    private float temperature;
    private float pressure;
    private float humidity;
    private CurrentConditions currentConditions;

    private ArrayList<Observer> observers;

    //加入新的第三方

    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    public WeatherData(CurrentConditions currentConditions) {
//        this.currentConditions = currentConditions;
        notifyObserver();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }

//    public void dataChange() {
//        //调用 接入方的 update
//        currentConditions.update(getTemperature(), getPressure(), getHumidity());
//    }

    //当数据有更新时，就调用 setData
    public void setData(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        //调用dataChange， 将最新的信息 推送给 接入方 currentConditions
        notifyObserver();
    }


    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        if (observers.contains(o)) {
            observers.remove(o);
        }
    }

    // 遍历所有的观察者并遍历
    @Override
    public void notifyObserver() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(this.temperature, this.pressure, this.humidity);
        }
    }
}
