package com.dou.demo.instructions.constants.ldc;

import com.dou.demo.instructions.base.InstructionIndex16;
import com.dou.demo.rtda.Frame;
import com.dou.demo.rtda.OperandStack;
import com.dou.demo.rtda.heap.constantpool.RunTimeConstantPool;

/**
 * @Author: dxdou
 * @Date: 2025/02/21
 */
public class LDC2_W extends InstructionIndex16 {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        RunTimeConstantPool runTimeConstantPool = frame.method().clazz().constantPool();
        Object c = runTimeConstantPool.getConstants(this.idx);
        if (c instanceof Long) {
            stack.pushLong((Long) c);
            return;
        }
        if (c instanceof Double){
            stack.pushDouble((Double) c);
        }
        throw new ClassFormatError();

    }

}
