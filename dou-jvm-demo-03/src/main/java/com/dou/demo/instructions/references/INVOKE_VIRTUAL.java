package com.dou.demo.instructions.references;

import com.dou.demo.instructions.base.InstructionIndex16;
import com.dou.demo.rtda.Frame;
import com.dou.demo.rtda.OperandStack;
import com.dou.demo.rtda.heap.constantpool.MethodRef;
import com.dou.demo.rtda.heap.constantpool.RunTimeConstantPool;

public class INVOKE_VIRTUAL extends InstructionIndex16 {

    @Override
    public void execute(Frame frame) {
        RunTimeConstantPool cp = frame.method().clazz().constantPool();
        MethodRef methodRef = (MethodRef) cp.getConstants(this.idx);
        if (methodRef.name.equals("println")) {
            OperandStack stack = frame.operandStack();
            switch (methodRef.descriptor) {
                case "(Z)V":
                    System.out.println(stack.popInt() != 0);
                    break;
                case "(C)V":
                    System.out.println(stack.popInt());
                    break;
                case "(I)V":
                case "(B)V":
                case "(S)V":
                    System.out.println(stack.popInt());
                    break;
                case "(F)V":
                    System.out.println(stack.popFloat());
                    break;
                case "(J)V":
                    System.out.println(stack.popLong());
                    break;
                case "(D)V":
                    System.out.println(stack.popDouble());
                    break;
                default:
                    System.out.println(methodRef.descriptor);
                    break;
            }
            stack.popRef();
        }
    }
}


