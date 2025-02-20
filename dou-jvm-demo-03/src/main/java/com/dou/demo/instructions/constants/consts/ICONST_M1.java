package com.dou.demo.instructions.constants.consts;

import com.dou.demo.instructions.base.InstructionNoOperands;
import com.dou.demo.rtda.Frame;

//push int constant
public class ICONST_M1 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        frame.operandStack().pushInt(-1);
    }
    
}
