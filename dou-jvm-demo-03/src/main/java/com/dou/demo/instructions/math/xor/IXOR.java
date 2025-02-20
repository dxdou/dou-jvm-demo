package com.dou.demo.instructions.math.xor;

import com.dou.demo.instructions.base.InstructionNoOperands;
import com.dou.demo.rtda.Frame;
import com.dou.demo.rtda.OperandStack;

//boolean xor int
public class IXOR extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        int v1 = stack.popInt();
        int v2 = stack.popInt();
        int res = v1 ^ v2;
        stack.pushInt(res);
    }

}
