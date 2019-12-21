package com.ntuzy.observer;

public class Client {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditions currentConditions = new CurrentConditions();

        weatherData.registerObserver(currentConditions);

        weatherData.setData(20f, 30f, 40f);
    }
}
