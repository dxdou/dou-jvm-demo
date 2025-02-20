package com.dou.demo.instructions.extended.ifnull;

import com.dou.demo.instructions.base.Instruction;
import com.dou.demo.instructions.base.InstructionBranch;
import com.dou.demo.rtda.Frame;

//branch if reference is null
public class IFNULL extends InstructionBranch {

    @Override
    public void execute(Frame frame) {
        Object ref = frame.operandStack().popRef();
        if (null == ref) {
            Instruction.branch(frame, this.offset);
        }
    }
}
