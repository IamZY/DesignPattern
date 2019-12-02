package com.ntuzy.protoptype.deepclone;

import java.io.Serializable;

public class DeepCloneableTarget implements Serializable, Cloneable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String cloneName;

    private String cloneClass;

    public DeepCloneableTarget(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }

    // 该类的属性都是String 使用默认的Clone方法即可
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}