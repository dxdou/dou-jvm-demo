package com.dou.demo.instructions.conversions.f2x;

import com.dou.demo.instructions.base.InstructionNoOperands;
import com.dou.demo.rtda.Frame;
import com.dou.demo.rtda.OperandStack;

//convert float to long
public class F2L extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        float f = stack.popFloat();
        long l = (long) f;
        stack.pushLong(l);
    }
}
