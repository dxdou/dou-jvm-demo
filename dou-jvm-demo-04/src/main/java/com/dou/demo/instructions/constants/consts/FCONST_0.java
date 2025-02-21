package com.dou.demo.instructions.constants.consts;

import com.dou.demo.instructions.base.BytecodeReader;
import com.dou.demo.instructions.base.InstructionNoOperands;
import com.dou.demo.rtda.Frame;

public class FCONST_0 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        frame.operandStack().pushFloat(0);
    }

}
