package com.dou.demo.instructions.comparisons.if_icmp;

import com.dou.demo.instructions.base.Instruction;
import com.dou.demo.instructions.base.InstructionBranch;
import com.dou.demo.rtda.Frame;
import com.dou.demo.rtda.OperandStack;

public class IF_ICMPGT extends InstructionBranch {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        int val2 = stack.popInt();
        int val1 = stack.popInt();
        if (val1 > val2) {
            Instruction.branch(frame, this.offset);
        }
    }

}