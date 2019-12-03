package com.ntuzy.bridge;

// 折叠式手机的类
public class FoldedPhone extends Phone {
    public FoldedPhone(Brand brand) {
        super(brand);
    }

    @Override
    protected void open() {
        super.open();
        System.out.println("折叠样式的手机");
    }

    @Override
    protected void close() {
        super.close();
        System.out.println("折叠样式的手机");
    }


    @Override
    protected void call() {
        super.call();
        System.out.println("折叠样式的手机");
    }
}
