package com.dou.demo.instructions.comparisons.if_acmp;

import com.dou.demo.instructions.base.Instruction;
import com.dou.demo.instructions.base.InstructionBranch;
import com.dou.demo.rtda.Frame;

public class IF_ACMPEQ extends InstructionBranch {

    @Override
    public void execute(Frame frame) {
        if (_acmp(frame)) {
            Instruction.branch(frame, this.offset);
        }
    }

}
