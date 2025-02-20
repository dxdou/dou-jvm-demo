package com.dou.demo.instructions.conversions.i2x;

import com.dou.demo.instructions.base.InstructionNoOperands;
import com.dou.demo.rtda.Frame;
import com.dou.demo.rtda.OperandStack;

//convert int to float
public class I2F extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        int i = stack.popInt();
        float f = i;
        stack.pushFloat(f);
    }

}
