package com.dou.demo.instructions.constants.ldc;

import com.dou.demo.instructions.base.InstructionIndex8;
import com.dou.demo.rtda.Frame;
import com.dou.demo.rtda.OperandStack;
import com.dou.demo.rtda.heap.constantpool.RunTimeConstantPool;

/**
 * @Author: dxdou
 * @Date: 2025/02/21
 */
public class LDC extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        _ldc(frame, this.idx);
    }

    private void _ldc(Frame frame, int idx) {
        OperandStack stack = frame.operandStack();
        RunTimeConstantPool runTimeConstantPool = frame.method().clazz().constantPool();
        java.lang.Object c = runTimeConstantPool.getConstants(idx);

        if (c instanceof Integer){
            stack.pushInt((Integer) c);
            return;
        }

        if (c instanceof Float){
            stack.pushFloat((Float) c);
            return;
        }

        throw new RuntimeException("todo ldc");
    }

}
