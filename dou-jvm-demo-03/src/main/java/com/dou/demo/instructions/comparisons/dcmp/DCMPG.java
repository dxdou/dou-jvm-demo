package com.dou.demo.instructions.comparisons.dcmp;

import com.dou.demo.instructions.base.InstructionNoOperands;
import com.dou.demo.rtda.Frame;

public class DCMPG extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _dcmp(frame, true);
    }
    
}
