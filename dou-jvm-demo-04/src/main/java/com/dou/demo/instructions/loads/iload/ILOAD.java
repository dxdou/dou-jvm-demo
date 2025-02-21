package com.dou.demo.instructions.loads.iload;

import com.dou.demo.instructions.base.InstructionIndex8;
import com.dou.demo.rtda.Frame;

//load int from local variable
public class ILOAD extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        int val = frame.localVars().getInt(this.idx);
        frame.operandStack().pushInt(val);
    }
}

