package com.dou.demo.instructions.loads.aload;

import com.dou.demo.instructions.base.InstructionIndex8;
import com.dou.demo.rtda.Frame;
import com.dou.demo.rtda.heap.methodarea.Object;

//load reference from local variable
public class ALOAD extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        Object ref = frame.localVars().getRef(this.idx);
        frame.operandStack().pushRef(ref);
    }

}
