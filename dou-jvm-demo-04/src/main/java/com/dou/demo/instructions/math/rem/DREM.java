package com.dou.demo.instructions.math.rem;

import com.dou.demo.instructions.base.InstructionNoOperands;
import com.dou.demo.rtda.Frame;
import com.dou.demo.rtda.OperandStack;

//remainder double
public class DREM extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        double v2 = stack.popDouble();
        double v1 = stack.popDouble();
        double res = v1 % v2;
        stack.pushDouble(res);
    }

}
