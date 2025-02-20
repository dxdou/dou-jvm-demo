package com.dou.demo.instructions.math.neg;

import com.dou.demo.instructions.base.InstructionNoOperands;
import com.dou.demo.rtda.Frame;
import com.dou.demo.rtda.OperandStack;

//negate long
public class LNEG extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        long val = stack.popLong();
        stack.pushLong(-val);
    }

}
