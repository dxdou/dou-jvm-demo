package com.dou.demo.instructions.references;

import com.dou.demo.instructions.base.InstructionIndex16;
import com.dou.demo.rtda.Frame;

public class INVOKE_SPECIAL  extends InstructionIndex16 {

    @Override
    public void execute(Frame frame) {
        frame.operandStack().popRef();
    }

}