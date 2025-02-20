package com.dou.demo.instructions.stack.pop;

import com.dou.demo.instructions.base.InstructionNoOperands;
import com.dou.demo.rtda.Frame;
import com.dou.demo.rtda.OperandStack;

// Pop the top operand stack value
/*
bottom -> top
[...][c][b][a]
            |
            V
[...][c][b]
*/
public class POP extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        stack.popSlot();
    }

}
