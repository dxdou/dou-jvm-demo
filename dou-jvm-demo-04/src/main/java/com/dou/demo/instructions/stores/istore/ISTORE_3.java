package com.dou.demo.instructions.stores.istore;

import com.dou.demo.instructions.base.InstructionNoOperands;
import com.dou.demo.rtda.Frame;

public class ISTORE_3 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _istore(frame, 3);
    }

}

