package com.dou.demo.instructions.control.rtn;

import com.dou.demo.instructions.base.InstructionNoOperands;
import com.dou.demo.rtda.Frame;

/**
 * @Author: dxdou
 * @Date: 2025/02/20/18:52
 */
public class RETURN extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        frame.thread().popFrame();
    }
    
}
