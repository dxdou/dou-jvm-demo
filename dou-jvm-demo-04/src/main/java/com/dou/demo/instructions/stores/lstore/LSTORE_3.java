package com.dou.demo.instructions.stores.lstore;

import com.dou.demo.instructions.base.InstructionNoOperands;
import com.dou.demo.rtda.Frame;

public class LSTORE_3 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _lstore(frame, 3);
    }

}

