package com.dou.demo.instructions.control.rtn;

import com.dou.demo.instructions.base.InstructionNoOperands;
import com.dou.demo.rtda.Frame;
import com.dou.demo.rtda.Thread;

/**
 * @Author: dxdou
 * @Date: 2025/02/20/18:52
 */
public class LRETURN extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        Thread thread = frame.thread();
        Frame currentFrame = thread.popFrame();
        Frame invokerFrame = thread.topFrame();
        long val = currentFrame.operandStack().popLong();
        invokerFrame.operandStack().pushLong(val);
    }

}
