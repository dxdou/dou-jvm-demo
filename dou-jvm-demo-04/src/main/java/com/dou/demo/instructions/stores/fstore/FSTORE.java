package com.dou.demo.instructions.stores.fstore;

import com.dou.demo.instructions.base.InstructionIndex8;
import com.dou.demo.rtda.Frame;

public class FSTORE extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        _fstore(frame, this.idx);
    }

}
