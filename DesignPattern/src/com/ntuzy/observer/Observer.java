package com.ntuzy.observer;

// 观察者接口 由观察者
public interface Observer {
    void update(float temperature, float pressure, float humidity);
}
