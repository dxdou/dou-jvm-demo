package com.dou.demo.instructions.control.rtn;

import com.dou.demo.instructions.base.InstructionNoOperands;
import com.dou.demo.rtda.Frame;
import com.dou.demo.rtda.Thread;

/**
 * @Author: dxdou
 * @Date: 2025/02/21
 */
public class IRETURN extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        Thread thread = frame.thread();
        Frame currentFrame = thread.popFrame();
        Frame invokerFrame = thread.topFrame();
        int val = currentFrame.operandStack().popInt();
        invokerFrame.operandStack().pushInt(val);
    }

}
