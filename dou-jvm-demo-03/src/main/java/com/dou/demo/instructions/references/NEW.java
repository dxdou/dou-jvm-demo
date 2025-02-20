package com.dou.demo.instructions.references;

import com.dou.demo.instructions.base.InstructionIndex16;
import com.dou.demo.rtda.Frame;
import com.dou.demo.rtda.heap.constantpool.ClassRef;
import com.dou.demo.rtda.heap.constantpool.RunTimeConstantPool;
import com.dou.demo.rtda.heap.methodarea.Class;
import com.dou.demo.rtda.heap.methodarea.Object;

public class NEW extends InstructionIndex16 {

    @Override
    public void execute(Frame frame) {
        RunTimeConstantPool cp = frame.method().clazz().constantPool();
        ClassRef classRef = (ClassRef) cp.getConstants(this.idx);
        Class clazz = classRef.resolvedClass();
        if (clazz.isInterface() || clazz.isAbstract()) {
            throw new InstantiationError();
        }
        Object ref = clazz.newObject();
        frame.operandStack().pushRef(ref);
    }

}