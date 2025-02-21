package com.dou.demo.instructions.references;

import com.dou.demo.instructions.base.InstructionIndex16;
import com.dou.demo.rtda.Frame;
import com.dou.demo.rtda.OperandStack;
import com.dou.demo.rtda.heap.constantpool.ClassRef;
import com.dou.demo.rtda.heap.constantpool.RunTimeConstantPool;
import com.dou.demo.rtda.heap.methodarea.Class;
import com.dou.demo.rtda.heap.methodarea.Object;

public class CHECK_CAST extends InstructionIndex16 {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        Object ref = stack.popRef();
        stack.pushRef(ref);
        if (null == ref) return;
        RunTimeConstantPool cp = frame.method().clazz().constantPool();
        ClassRef clazzRef = (ClassRef) cp.getConstants(this.idx);
        Class clazz = clazzRef.resolvedClass();
        if (!ref.isInstanceOf(clazz)) {
            throw new ClassCastException();
        }
    }

}
