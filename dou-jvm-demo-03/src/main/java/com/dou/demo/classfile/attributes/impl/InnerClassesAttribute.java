package com.dou.demo.classfile.attributes.impl;

import com.dou.demo.classfile.ClassReader;
import com.dou.demo.classfile.attributes.AttributeInfo;

/**
 * @Author: dxdou
 * @Date: 2025/02/20/18:52
 */
public class InnerClassesAttribute implements AttributeInfo {

    private InnerClassInfo[] classes;

    @Override
    public void readInfo(ClassReader reader) {
        int numberOfClasses = reader.readUint16();
        this.classes = new InnerClassInfo[numberOfClasses];
        for (int i = 0; i < numberOfClasses; i++) {
            classes[i] = new InnerClassInfo(reader.readUint16(), reader.readUint16(), reader.readUint16(), reader.readUint16());
        }
    }

    static class InnerClassInfo {

        private int innerClassInfoIndex;
        private int outerClassInfoIndex;
        private int innerNameIndex;
        private int innerClassAccessFlags;

        InnerClassInfo(int innerClassInfoIndex, int outerClassInfoIndex, int innerNameIndex, int innerClassAccessFlags) {
            this.innerClassInfoIndex = innerClassInfoIndex;
            this.outerClassInfoIndex = outerClassInfoIndex;
            this.innerNameIndex = innerNameIndex;
            this.innerClassAccessFlags = innerClassAccessFlags;
        }
    }

}
