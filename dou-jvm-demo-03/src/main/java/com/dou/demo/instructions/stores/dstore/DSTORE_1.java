package com.dou.demo.instructions.stores.dstore;

import com.dou.demo.instructions.base.InstructionNoOperands;
import com.dou.demo.rtda.Frame;

public class DSTORE_1 extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        _dstore(frame, 1);
    }

}
