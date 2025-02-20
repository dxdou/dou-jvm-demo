package com.dou.demo.instructions.stores.xastore;

import com.dou.demo.instructions.base.InstructionNoOperands;
import com.dou.demo.rtda.Frame;
import com.dou.demo.rtda.OperandStack;
import com.dou.demo.rtda.heap.methodarea.Object;

/**
 * @Author: dxdou
 * @Date: 2025/02/20/18:52
 */
public class AASTORE extends InstructionNoOperands {

    @Override
    public void execute(Frame frame) {
        OperandStack stack = frame.operandStack();
        Object ref = stack.popRef();
        int idx = stack.popInt();
        Object arrRef = stack.popRef();

        if (null == arrRef) throw new NullPointerException();

    }
    
}
