package com.dou.demo.instructions.math.sh;

import com.dou.demo.instructions.base.InstructionNoOperands;
import com.dou.demo.rtda.Frame;
import com.dou.demo.rtda.OperandStack;

//logical shift right long
public class LUSHR extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        int v2 = stack.popInt();
        long v1 = stack.popLong();
        long s = v2 & 0x3f;
        long res = v1 >> s;
        stack.pushLong(res);
    }

}

