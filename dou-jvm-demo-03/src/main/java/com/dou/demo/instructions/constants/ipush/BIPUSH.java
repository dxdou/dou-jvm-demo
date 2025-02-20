package com.dou.demo.instructions.constants.ipush;

import com.dou.demo.instructions.base.BytecodeReader;
import com.dou.demo.instructions.base.Instruction;
import com.dou.demo.rtda.Frame;

//bipush指令从操作数中获取一个byte型整数，扩展成int型，然后推入栈顶。
public class BIPUSH implements Instruction {

    private byte val;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.val = reader.readByte();
    }

    @Override
    public void execute(Frame frame) {
        frame.operandStack().pushInt(val);
    }

}
