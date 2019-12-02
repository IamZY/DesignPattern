package com.ntuzy.protoptype.deepclone;

import java.io.*;

public class DeepProtoType implements Serializable, Cloneable {

    public String name;
    public DeepCloneableTarget deepCloneableTarget;  // 引用类型的属性


    public DeepProtoType() {

    }


    // 深拷贝  1 方式1 使用clone方法
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object deep = null;
        // 完成对基本数据类型（属性）和String的clone
        deep = super.clone();

        // 对引用类型属性进行单独处理
        DeepProtoType deepProtoType = (DeepProtoType) deep;
        deepProtoType.deepCloneableTarget = (DeepCloneableTarget) deepCloneableTarget.clone();

        return deep;
    }


    // 方式2 对象序列化进行深拷贝 推荐使用
    public Object deepClone() {
        // 创建流对象
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;

        try {
            // 序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this); // 当前这个对象以对象流的形式输出

            // 反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);

            DeepProtoType copyObj = (DeepProtoType) ois.readObject();


            return copyObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            // 关闭流
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }


}
