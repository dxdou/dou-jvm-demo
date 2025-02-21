package com.dou.demo.classfile.constantpool.impl;

import com.dou.demo.classfile.ClassReader;
import com.dou.demo.classfile.constantpool.ConstantInfo;

/**
 * @Author: dxdou
 * @Date: 2025/02/21
 */
public class ConstantIntegerInfo implements ConstantInfo {

    private long val;

    @Override
    public void readInfo(ClassReader reader) {
        this.val = reader.readUint32();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_INTEGER;
    }

    public long value(){
        return this.val;
    }

}
