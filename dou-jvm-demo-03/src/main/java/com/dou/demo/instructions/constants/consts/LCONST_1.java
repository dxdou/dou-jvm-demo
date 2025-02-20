package com.dou.demo.instructions.constants.consts;

import com.dou.demo.instructions.base.InstructionNoOperands;
import com.dou.demo.rtda.Frame;

public class LCONST_1 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
         frame.operandStack().pushLong(1);
    }
}
