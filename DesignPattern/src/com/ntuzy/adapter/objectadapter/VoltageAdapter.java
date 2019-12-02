package com.ntuzy.adapter.objectadapter;

// 适配器类
public class VoltageAdapter implements IVoltage5V {

    private Voltage220V voltage220V; // 关联关系中的聚和

    // 通过构造器传入220v的实例
    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }


    @Override
    public int output5V() {
        // 获取220v的电压
        int dst = 0;

        if (null != voltage220V) {
            int src = voltage220V.output220V();  // 获取220v电压
            System.out.println("使用对象适配器，进行适配");
            dst = src/44;
            System.out.println("转换过的电压=" + dst);
        }
        return dst;
    }
}
