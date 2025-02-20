package com.dou.demo.instructions.constants.consts;

import com.dou.demo.instructions.base.InstructionNoOperands;
import com.dou.demo.rtda.Frame;

public class DCONST_1 extends InstructionNoOperands {
    @Override
    public void execute(Frame frame) {
        frame.operandStack().pushDouble(1.0);
    }
}
