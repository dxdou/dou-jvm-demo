package com.dou.demo.classfile.attributes.impl;

import com.dou.demo.classfile.ClassReader;
import com.dou.demo.classfile.attributes.AttributeInfo;

/**
 * @Author: dxdou
 * @Date: 2025/02/20/18:52
 */
public class UnparsedAttribute implements AttributeInfo {

    private String name;
    private int length;
    private byte[] info;

    public UnparsedAttribute(String attrName, int attrLen) {
        this.name = attrName;
        this.length = attrLen;
    }

    @Override
    public void readInfo(ClassReader reader) {
        this.info = reader.readBytes(this.length);
    }

    public byte[] info(){
        return this.info;
    }

}
