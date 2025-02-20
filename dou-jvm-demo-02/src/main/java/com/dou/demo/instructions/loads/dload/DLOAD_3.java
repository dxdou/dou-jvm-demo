package com.dou.demo.instructions.loads.dload;

import com.dou.demo.instructions.base.InstructionNoOperands;
import com.dou.demo.rtda.Frame;

public class DLOAD_3 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        double val = frame.localVars().getDouble(3);
        frame.operandStack().pushRef(val);
    }

}
