package com.dou.demo.classfile.constantpool.impl;


import com.dou.demo.classfile.ClassReader;
import com.dou.demo.classfile.constantpool.ConstantInfo;

/**
 * @Author: dxdou
 * @Date: 2025/02/21
 */
public class ConstantInvokeDynamicInfo implements ConstantInfo {

    private int bootstrapMethodAttrIdx;
    private int nameAndTypeIdx;

    @Override
    public void readInfo(ClassReader reader) {
        this.bootstrapMethodAttrIdx = reader.readUint16();
        this.nameAndTypeIdx = reader.readUint16();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_INVOKEDYNAMIC;
    }
}
