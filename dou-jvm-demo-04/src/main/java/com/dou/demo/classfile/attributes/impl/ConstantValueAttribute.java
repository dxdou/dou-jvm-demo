package com.dou.demo.classfile.attributes.impl;

import com.dou.demo.classfile.ClassReader;
import com.dou.demo.classfile.attributes.AttributeInfo;

/**
 * @Author: dxdou
 * @Date: 2025/02/21
 */
public class ConstantValueAttribute implements AttributeInfo {

    private int constantValueIdx;

    @Override
    public void readInfo(ClassReader reader) {
        this.constantValueIdx = reader.readUint16();
    }

    public int constantValueIdx(){
        return this.constantValueIdx;
    }

}
