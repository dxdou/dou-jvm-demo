package com.dou.demo.instructions.control;

import com.dou.demo.instructions.base.Instruction;
import com.dou.demo.instructions.base.InstructionBranch;
import com.dou.demo.rtda.Frame;

//branch always
public class GOTO extends InstructionBranch {

    @Override
    public void execute(Frame frame) {
        Instruction.branch(frame, this.offset);
    }
}
