package com.dou.demo.instructions.loads.dload;

import com.dou.demo.instructions.base.InstructionIndex8;
import com.dou.demo.rtda.Frame;

public class DLOAD extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        double val = frame.localVars().getDouble(this.idx);
        frame.operandStack().pushRef(val);
    }

}