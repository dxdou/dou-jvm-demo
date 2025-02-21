package com.dou.demo.instructions.references;

import com.dou.demo.instructions.base.ClassInitLogic;
import com.dou.demo.instructions.base.InstructionIndex16;
import com.dou.demo.instructions.base.MethodInvokeLogic;
import com.dou.demo.rtda.Frame;
import com.dou.demo.rtda.heap.constantpool.MethodRef;
import com.dou.demo.rtda.heap.constantpool.RunTimeConstantPool;
import com.dou.demo.rtda.heap.methodarea.Class;
import com.dou.demo.rtda.heap.methodarea.Method;

/**
 * @Author: dxdou
 * @Date: 2025/02/21
 * invokestatic调用static方法
 */
public class INVOKE_STATIC extends InstructionIndex16 {

    @Override
    public void execute(Frame frame) {
        RunTimeConstantPool runTimeConstantPool = frame.method().clazz().constantPool();
        MethodRef methodRef = (MethodRef) runTimeConstantPool.getConstants(this.idx);
        Method resolvedMethod = methodRef.ResolvedMethod();

        if (!resolvedMethod.isStatic()) {
            throw new IncompatibleClassChangeError();
        }

        Class clazz = resolvedMethod.clazz();
        if (!clazz.initStarted()) {
            frame.revertNextPC();
            ClassInitLogic.initClass(frame.thread(), clazz);
            return;
        }

        MethodInvokeLogic.invokeMethod(frame, resolvedMethod);
    }
}
