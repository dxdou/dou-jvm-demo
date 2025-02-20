package com.dou.demo.instructions.references;

import com.dou.demo.classfile.constantpool.ConstantPool;
import com.dou.demo.instructions.base.InstructionIndex16;
import com.dou.demo.rtda.Frame;
import com.dou.demo.rtda.OperandStack;
import com.dou.demo.rtda.heap.constantpool.FieldRef;
import com.dou.demo.rtda.heap.constantpool.RunTimeConstantPool;
import com.dou.demo.rtda.heap.methodarea.Class;
import com.dou.demo.rtda.heap.methodarea.Field;
import com.dou.demo.rtda.heap.methodarea.Method;
import com.dou.demo.rtda.heap.methodarea.Slots;

public class PUT_STATIC extends InstructionIndex16 {

    @Override
    public void execute(Frame frame) {
        Method currentMethod = frame.method();
        Class currentClazz = currentMethod.clazz();
        RunTimeConstantPool runTimeConstantPool = currentClazz.constantPool();
        FieldRef fieldRef = (FieldRef) runTimeConstantPool.getConstants(this.idx);
        Field field = fieldRef.resolvedField();
        Class clazz = field.clazz();

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
                slots.setInt(slotId, stack.popInt());
                break;
            case "F":
                slots.setFloat(slotId, stack.popFloat());
                break;
            case "J":
                slots.setLong(slotId, stack.popLong());
                break;
            case "D":
                slots.setDouble(slotId, stack.popDouble());
                break;
            case "L":
            case "[":
                slots.setRef(slotId, stack.popRef());
                break;
            default:
                break;
        }
    }

}
