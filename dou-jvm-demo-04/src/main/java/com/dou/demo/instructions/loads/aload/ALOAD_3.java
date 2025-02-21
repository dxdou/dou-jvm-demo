package com.dou.demo.instructions.loads.aload;

import com.dou.demo.instructions.base.InstructionNoOperands;
import com.dou.demo.rtda.Frame;
import com.dou.demo.rtda.heap.methodarea.Object;

public class ALOAD_3 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        Object ref = frame.localVars().getRef(3);
        frame.operandStack().pushRef(ref);
    }

}
