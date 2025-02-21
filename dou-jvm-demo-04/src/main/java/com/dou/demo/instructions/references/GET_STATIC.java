package com.dou.demo.instructions.references;

import com.dou.demo.instructions.base.ClassInitLogic;
import com.dou.demo.instructions.base.InstructionIndex16;
import com.dou.demo.rtda.Frame;
import com.dou.demo.rtda.OperandStack;
import com.dou.demo.rtda.heap.constantpool.FieldRef;
import com.dou.demo.rtda.heap.constantpool.RunTimeConstantPool;
import com.dou.demo.rtda.heap.methodarea.Class;
import com.dou.demo.rtda.heap.methodarea.Field;
import com.dou.demo.rtda.heap.methodarea.Slots;

public class GET_STATIC extends InstructionIndex16 {

    @Override
    public void execute(Frame frame) {
        RunTimeConstantPool runTimeConstantPool = frame.method().clazz().constantPool();
        FieldRef ref = (FieldRef) runTimeConstantPool.getConstants(this.idx);
        Field field = ref.resolvedField();
        Class clazz = field.clazz();
        if (!clazz.initStarted()) {
            frame.revertNextPC();
            ClassInitLogic.initClass(frame.thread(), clazz);
            return;
        }
        //java.lang.IncompatibleClassChangeError
        if (!field.isStatic()) {
            throw new IncompatibleClassChangeError();
        }

        String descriptor = field.descriptor();
        int slotId = field.slotId();
        Slots slots = clazz.staticVars();
        OperandStack stack = frame.operandStack();
        switch (descriptor.substring(0, 1)) {
            case "Z":
            case "B":
            case "C":
            case "S":
            case "I":
                stack.pushInt(slots.getInt(slotId));
                break;
            case "F":
                stack.pushFloat(slots.getFloat(slotId));
                break;
            case "J":
                stack.pushLong(slots.getLong(slotId));
                break;
            case "D":
                stack.pushDouble(slots.getDouble(slotId));
                break;
            case "L":
            case "[":
                stack.pushRef(slots.getRef(slotId));
                break;
            default:
                break;
        }
    }

}
