package com.ntuzy.bridge;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Client {
    public static void main(String[] args){
        // 获取折叠式手机样式+品牌

        Phone phone1 = new FoldedPhone(new XiaoMi());
        phone1.open();
        phone1.call();
        phone1.close();

//        String str = "a";
//        str = "b";


    }
}
