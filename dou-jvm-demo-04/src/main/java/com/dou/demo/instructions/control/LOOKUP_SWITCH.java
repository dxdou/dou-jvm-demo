package com.dou.demo.instructions.control;

import com.dou.demo.instructions.base.BytecodeReader;
import com.dou.demo.instructions.base.Instruction;
import com.dou.demo.rtda.Frame;

//access jump table by key match and jump
public class LOOKUP_SWITCH implements Instruction {

    private int defaultOffset;
    private int npairs;
    private int[] matchOffsets;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        reader.skipPadding();
        this.defaultOffset = reader.readInt();
        this.npairs = reader.readInt();
        this.matchOffsets = reader.readInts(this.npairs * 2);
    }

    @Override
    public void execute(Frame frame) {
        int key = frame.operandStack().popInt();
        for (int i = 0; i < this.npairs * 2; i += 2) {
            if (this.matchOffsets[i] == key) {
                int offset = this.matchOffsets[i + 1];
                Instruction.branch(frame, offset);
            }
        }
        Instruction.branch(frame, this.defaultOffset);
    }
}
