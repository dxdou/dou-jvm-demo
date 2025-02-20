package com.dou.demo.instructions.comparisons.fcmp;

import com.dou.demo.instructions.base.InstructionNoOperands;
import com.dou.demo.rtda.Frame;

public class FCMPL extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _fcmp(frame, false);
    }

}
