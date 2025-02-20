package com.dou.demo.rtda.heap.constantpool;

import com.dou.demo.classfile.constantpool.impl.ConstantClassInfo;

public class ClassRef extends SymRef {

    public static ClassRef newClassRef(RunTimeConstantPool runTimeConstantPool, ConstantClassInfo classInfo) {
        ClassRef ref = new ClassRef();
        ref.runTimeConstantPool = runTimeConstantPool;
        ref.className = classInfo.name();
        return ref;
    }

}
