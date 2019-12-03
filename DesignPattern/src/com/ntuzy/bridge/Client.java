package com.ntuzy.bridge;

public class Client {
    public static void main(String[] args){
        // 获取折叠式手机样式+品牌

        Phone phone1 = new FoldedPhone(new XiaoMi());
        phone1.open();
        phone1.call();
        phone1.close();

    }
}
