package com.dou.demo.instructions.control.rtn;

import com.dou.demo.instructions.base.InstructionNoOperands;
import com.dou.demo.rtda.Frame;
import com.dou.demo.rtda.Thread;
import com.dou.demo.rtda.heap.methodarea.Object;

/**
 * @Author: dxdou
 * @Date: 2025/02/20/18:52
 */
public class ARETURN extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        Thread thread = frame.thread();
        Frame currentFrame = thread.popFrame();
        Frame invokerFrame = thread.topFrame();
        Object ref = currentFrame.operandStack().popRef();
        invokerFrame.operandStack().pushRef(ref);
    }

}