package com.dou.demo.instructions.references;

import com.dou.demo.instructions.base.InstructionIndex16;
import com.dou.demo.instructions.base.MethodInvokeLogic;
import com.dou.demo.rtda.Frame;
import com.dou.demo.rtda.OperandStack;
import com.dou.demo.rtda.heap.constantpool.MethodRef;
import com.dou.demo.rtda.heap.constantpool.RunTimeConstantPool;
import com.dou.demo.rtda.heap.methodarea.Class;
import com.dou.demo.rtda.heap.methodarea.Method;
import com.dou.demo.rtda.heap.methodarea.MethodLookup;
import com.dou.demo.rtda.heap.methodarea.Object;

/**
 * invokevirtual调用对象实例方法 
 */
public class INVOKE_VIRTUAL extends InstructionIndex16 {

    @Override
    public void execute(Frame frame) {

        Class currentClass = frame.method().clazz();
        RunTimeConstantPool runTimeConstantPool = currentClass.constantPool();
        MethodRef methodRef = (MethodRef) runTimeConstantPool.getConstants(this.idx);
        Method resolvedMethod = methodRef.ResolvedMethod();
        if (resolvedMethod.isStatic()) {
            throw new IncompatibleClassChangeError();
        }

        Object ref = frame.operandStack().getRefFromTop(resolvedMethod.argSlotCount() - 1);
        if (null == ref) {
            if ("println".equals(methodRef.name())) {
                _println(frame.operandStack(), methodRef.descriptor());
                return;
            }
            throw new NullPointerException();
        }

        if (resolvedMethod.isProtected() &&
                resolvedMethod.clazz().isSubClassOf(currentClass) &&
                !resolvedMethod.clazz().getPackageName().equals(currentClass.getPackageName()) &&
                ref.clazz() != currentClass &&
                !ref.clazz().isSubClassOf(currentClass)) {
            throw new IllegalAccessError();
        }

        Method methodToBeInvoked = MethodLookup.lookupMethodInClass(ref.clazz(), methodRef.name(), methodRef.descriptor());
        if (null == methodToBeInvoked || methodToBeInvoked.isAbstract()) {
            throw new AbstractMethodError();
        }

        MethodInvokeLogic.invokeMethod(frame, methodToBeInvoked);
    }

    //hack
    private void _println(OperandStack stack, String descriptor) {
        switch (descriptor) {
            case "(Z)V":
                System.out.println(stack.popInt() != 0);
                break;
            case "(C)V":
                System.out.println(stack.popInt());
                break;
            case "(I)V":
            case "(B)V":
            case "(S)V":
                System.out.println(stack.popInt());
                break;
            case "(F)V":
                System.out.println(stack.popFloat());
                break;
            case "(J)V":
                System.out.println(stack.popLong());
                break;
            case "(D)V":
                System.out.println(stack.popDouble());
                break;
            default:
                System.out.println(descriptor);
                break;
        }
        stack.popRef();
    }
}


