package com.dou.demo.instructions.references;

import com.dou.demo.instructions.base.BytecodeReader;
import com.dou.demo.instructions.base.Instruction;
import com.dou.demo.instructions.base.MethodInvokeLogic;
import com.dou.demo.rtda.Frame;
import com.dou.demo.rtda.heap.constantpool.InterfaceMethodRef;
import com.dou.demo.rtda.heap.constantpool.RunTimeConstantPool;
import com.dou.demo.rtda.heap.methodarea.Method;
import com.dou.demo.rtda.heap.methodarea.MethodLookup;
import com.dou.demo.rtda.heap.methodarea.Object;

/**
 * @Author: dxdou
 * @Date: 2025/02/21
 * invokeinterface调用接口方法
 */
public class INVOKE_INTERFACE implements Instruction {

    private int idx;

    @Override
    public void fetchOperands(BytecodeReader reader) {
        this.idx = reader.readShort();
        reader.readByte();
        reader.readByte();
    }

    @Override
    public void execute(Frame frame) {
        RunTimeConstantPool runTimeConstantPool = frame.method().clazz().constantPool();
        InterfaceMethodRef methodRef = (InterfaceMethodRef) runTimeConstantPool.getConstants(this.idx);
        Method resolvedMethod = methodRef.resolvedInterfaceMethod();
        if (resolvedMethod.isStatic() || resolvedMethod.isPrivate()) {
            throw new IncompatibleClassChangeError();
        }
        Object ref = frame.operandStack().getRefFromTop(resolvedMethod.argSlotCount() - 1);
        if (null == ref) {
            throw new NullPointerException();
        }
        if (!ref.clazz().isImplements(methodRef.resolvedClass())) {
            throw new IncompatibleClassChangeError();
        }
        Method methodToBeInvoked = MethodLookup.lookupMethodInClass(ref.clazz(), methodRef.name(), methodRef.descriptor());
        if (null == methodToBeInvoked || methodToBeInvoked.isAbstract()) {
            throw new AbstractMethodError();
        }
        if (!methodToBeInvoked.isPublic()) {
            throw new IllegalAccessError();
        }

        MethodInvokeLogic.invokeMethod(frame, methodToBeInvoked);

    }

}
