package com.dou.demo.instructions.conversions.l2x;

import com.dou.demo.instructions.base.InstructionNoOperands;
import com.dou.demo.rtda.Frame;
import com.dou.demo.rtda.OperandStack;

//convert long to float
public class L2F extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        long l = stack.popLong();
        float f = l;
        stack.pushFloat(f);
    }

}
