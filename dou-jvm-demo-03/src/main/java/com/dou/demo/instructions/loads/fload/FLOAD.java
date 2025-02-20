package com.dou.demo.instructions.loads.fload;

import com.dou.demo.instructions.base.InstructionIndex8;
import com.dou.demo.rtda.Frame;

//load float from local variable
public class FLOAD extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        Float val = frame.localVars().getFloat(this.idx);
        frame.operandStack().pushFloat(val);
    }

}
