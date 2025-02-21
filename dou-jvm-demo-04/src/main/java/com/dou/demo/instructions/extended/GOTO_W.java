package com.dou.demo.instructions.extended;

import com.dou.demo.instructions.base.BytecodeReader;
import com.dou.demo.instructions.base.Instruction;
import com.dou.demo.rtda.Frame;

//branch always(wide index)
public class GOTO_W implements Instruction {

    private int offset;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.offset = reader.readInt();
    }

    @Override
    public void execute(Frame frame) {
        Instruction.branch(frame, this.offset);
    }

}
