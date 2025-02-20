package com.dou.demo.instructions.loads.lload;

import com.dou.demo.instructions.base.InstructionNoOperands;
import com.dou.demo.rtda.Frame;

public class LLOAD_2 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        Long val = frame.localVars().getLong(2);
        frame.operandStack().pushLong(val);
    }

}
