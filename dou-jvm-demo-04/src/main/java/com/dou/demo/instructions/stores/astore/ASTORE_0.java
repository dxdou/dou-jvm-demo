package com.dou.demo.instructions.stores.astore;

import com.dou.demo.instructions.base.InstructionNoOperands;
import com.dou.demo.rtda.Frame;

public class ASTORE_0 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _astore(frame, 0);
    }

}
