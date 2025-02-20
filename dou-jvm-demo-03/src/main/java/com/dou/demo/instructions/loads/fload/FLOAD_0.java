package com.dou.demo.instructions.loads.fload;

import com.dou.demo.instructions.base.InstructionNoOperands;
import com.dou.demo.rtda.Frame;

public class FLOAD_0 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        Float val = frame.localVars().getFloat(0);
        frame.operandStack().pushFloat(val);
    }

}
