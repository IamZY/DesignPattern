package com.ntuzy.adapter.interfaceadapter;

public class Client {
    public static void main(String[] args) {
        AbsAdapter absAdapter = new AbsAdapter() {
            @Override
            public void m1() {
                super.m1();
            }
        };

        absAdapter.m2();

    }
}
