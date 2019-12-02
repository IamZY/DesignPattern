package com.ntuzy.adapter.classadapter;

// 适配器类
public class VoltageAdapter extends Voltage220V implements IVoltage5V {
    @Override
    public int output5V() {
        // 获取220v的电压
        int srcV = output220V();
        int dstV = srcV / 44;   // 转成5v

        return dstV;
    }
}
