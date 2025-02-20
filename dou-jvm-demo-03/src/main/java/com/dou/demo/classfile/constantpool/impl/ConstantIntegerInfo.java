package com.dou.demo.classfile.constantpool.impl;

import com.dou.demo.classfile.ClassReader;
import com.dou.demo.classfile.constantpool.ConstantInfo;

/**
 * @Author: dxdou
 * @Date: 2025/02/20/18:52
 */
public class ConstantIntegerInfo implements ConstantInfo {

    private int val;

    @Override
    public void readInfo(ClassReader reader) {
        this.val = reader.readUint32TInteger();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_INTEGER;
    }

    public int value(){
        return this.val;
    }

}
