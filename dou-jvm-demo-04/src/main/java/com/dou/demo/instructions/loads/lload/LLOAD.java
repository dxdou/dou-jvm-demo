package com.dou.demo.instructions.loads.lload;

import com.dou.demo.instructions.base.InstructionIndex8;
import com.dou.demo.rtda.Frame;

public class LLOAD extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        Long val = frame.localVars().getLong(this.idx);
        frame.operandStack().pushLong(val);
    }

}
