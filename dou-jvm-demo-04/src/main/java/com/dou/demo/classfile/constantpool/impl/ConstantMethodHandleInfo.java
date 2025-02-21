package com.dou.demo.classfile.constantpool.impl;

import com.dou.demo.classfile.ClassReader;
import com.dou.demo.classfile.constantpool.ConstantInfo;

/**
 * @Author: dxdou
 * @Date: 2025/02/21
 */
public class ConstantMethodHandleInfo implements ConstantInfo {

    private int referenceKind;
    private int referenceIndex;

    @Override
    public void readInfo(ClassReader reader) {
        this.referenceKind = reader.readUint8();
        this.referenceIndex = reader.readUint16();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_METHODHANDLE;
    }
}
