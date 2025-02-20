package com.dou.demo.instructions.comparisons.ifcond;

import com.dou.demo.instructions.base.Instruction;
import com.dou.demo.instructions.base.InstructionBranch;
import com.dou.demo.rtda.Frame;

public class IFLT extends InstructionBranch {

    @Override
    public void execute(Frame frame) {
        int val = frame.operandStack().popInt();
        if (val < 0) {
            Instruction.branch(frame, this.offset);
        }
    }
}
