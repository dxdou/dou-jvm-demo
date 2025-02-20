package com.dou.demo.instructions.stores.fstore;

import com.dou.demo.instructions.base.InstructionNoOperands;
import com.dou.demo.rtda.Frame;

public class FSTORE_3 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _fstore(frame, 3);
    }

}
