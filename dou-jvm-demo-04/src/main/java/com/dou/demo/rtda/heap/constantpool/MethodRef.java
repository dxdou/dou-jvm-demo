package com.dou.demo.rtda.heap.constantpool;

import com.dou.demo.classfile.constantpool.impl.ConstantMethodRefInfo;
import com.dou.demo.rtda.heap.methodarea.Class;
import com.dou.demo.rtda.heap.methodarea.Method;
import com.dou.demo.rtda.heap.methodarea.MethodLookup;

public class MethodRef extends MemberRef {

    private Method method;

    public static MethodRef newMethodRef(RunTimeConstantPool runTimeConstantPool, ConstantMethodRefInfo refInfo) {
        MethodRef ref = new MethodRef();
        ref.runTimeConstantPool = runTimeConstantPool;
        ref.copyMemberRefInfo(refInfo);
        return ref;
    }

    public Method ResolvedMethod() {
        if (null == this.method) {
            this.resolveMethodRef();
        }
        return this.method;
    }

    private void resolveMethodRef() {
        Class d = this.runTimeConstantPool.getClazz();
        Class c = this.resolvedClass();
        if (c.isInterface()) {
            throw new IncompatibleClassChangeError();
        }

        Method method = lookupMethod(c, this.name, this.descriptor);
        if (null == method){
            throw new NoSuchMethodError();
        }

        if (!method.isAccessibleTo(d)){
            throw new IllegalAccessError();
        }

        this.method = method;
    }

    public Method lookupMethod(Class clazz, String name, String descriptor) {
        Method method = MethodLookup.lookupMethodInClass(clazz, name, descriptor);
        if (null == method) {
            method = MethodLookup.lookupMethodInInterfaces(clazz.interfaces, name, descriptor);
        }
        return method;
    }

}
