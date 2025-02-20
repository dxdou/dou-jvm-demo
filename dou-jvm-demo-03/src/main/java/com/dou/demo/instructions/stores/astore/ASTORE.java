package com.dou.demo.instructions.stores.astore;

import com.dou.demo.instructions.base.InstructionIndex8;
import com.dou.demo.rtda.Frame;

//store reference into local variable
public class ASTORE extends InstructionIndex8 {

    @Override
    public void execute(Frame frame) {
        _astore(frame, this.idx);
    }

}
