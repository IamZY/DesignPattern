package com.ntuzy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Client {
    public static void main(String[] args){
        Object o1 = true ? new Integer(1) : new Double(2.0);
        Object o2;
        if (true) {
            o2 = new Integer(1);
        } else {
            o2 = new Double(2.0);
        }
        System.out.print(o1);
        System.out.print(" ");
        System.out.print(o2);

        System.out.println(-12 % -5);

        Map<String,String> map = new HashMap<>();
        map.put(null,null);
//        ArrayList arrayList = new ArrayList()
//        LinkedList linkedList = new LinkedList();
    }
}
