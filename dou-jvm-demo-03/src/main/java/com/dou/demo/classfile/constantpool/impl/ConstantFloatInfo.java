package com.dou.demo.classfile.constantpool.impl;

import com.dou.demo.classfile.ClassReader;
import com.dou.demo.classfile.constantpool.ConstantInfo;

/**
 * @Author: dxdou
 * @Date: 2025/02/20/18:52
 */
public class ConstantFloatInfo implements ConstantInfo {

    private float val;

    @Override
    public void readInfo(ClassReader reader) {
       this.val = reader.readUint64TFloat();
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_FLOAT;
    }

    public float value(){
        return this.val;
    }

}
