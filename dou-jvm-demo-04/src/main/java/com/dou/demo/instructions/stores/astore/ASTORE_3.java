package com.dou.demo.instructions.stores.astore;

import com.dou.demo.instructions.base.InstructionNoOperands;
import com.dou.demo.rtda.Frame;

public class ASTORE_3 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _astore(frame, 3);
    }

}
