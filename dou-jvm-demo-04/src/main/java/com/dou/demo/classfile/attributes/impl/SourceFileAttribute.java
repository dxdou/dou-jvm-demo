package com.dou.demo.classfile.attributes.impl;

import com.dou.demo.classfile.ClassReader;
import com.dou.demo.classfile.attributes.AttributeInfo;
import com.dou.demo.classfile.constantpool.ConstantPool;

/**
 * @Author: dxdou
 * @Date: 2025/02/21
 */
public class SourceFileAttribute implements AttributeInfo {

    private ConstantPool constantPool;
    private int sourceFileIdx;

    public SourceFileAttribute(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.sourceFileIdx = reader.readUint16();
    }

    public String fileName(){
        return this.constantPool.getUTF8(this.sourceFileIdx);
    }

}
