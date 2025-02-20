package com.dou.demo.classfile.constantpool.impl;

import com.dou.demo.classfile.constantpool.ConstantPool;

/**
 * @Author: dxdou
 * @Date: 2025/02/20/18:52
 */
public class ConstantFieldRefInfo extends ConstantMemberRefInfo {

    public ConstantFieldRefInfo(ConstantPool constantPool) {
        super(constantPool);
    }

    @Override
    public int tag() {
        return this.CONSTANT_TAG_FIELDREF;
    }

}
