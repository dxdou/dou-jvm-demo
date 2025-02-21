package com.dou.demo.classfile.constantpool.impl;

import com.dou.demo.classfile.ClassReader;
import com.dou.demo.classfile.constantpool.ConstantInfo;
import com.dou.demo.classfile.constantpool.ConstantPool;

/**
 * @Author: dxdou
 * @Date: 2025/02/21
 */
public class ConstantClassInfo implements ConstantInfo {

    public ConstantPool constantPool;
    public int nameIdx;

    public ConstantClassInfo(ConstantPool constantPool) {
         this.constantPool = constantPool;
    }

    @Override
    public void readInfo(ClassReader reader) {
         this.nameIdx = reader.readUint16();
    }

    public String name(){
        return this.constantPool.getUTF8(this.nameIdx);
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_CLASS;
    }

}
