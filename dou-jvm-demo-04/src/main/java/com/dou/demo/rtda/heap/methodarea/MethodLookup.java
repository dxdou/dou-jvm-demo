package com.dou.demo.rtda.heap.methodarea;

/**
 * @Author: dxdou
 * @Date: 2025/02/21
 */
public class MethodLookup {

    static public Method lookupMethodInClass(Class clazz, String name, String descriptor) {
        for (Class c = clazz; c != null; c = c.superClass) {
            for (Method method : c.methods) {
                if (method.name.equals(name) && method.descriptor.equals(descriptor)) {
                    return method;
                }
            }
        }
        return null;
    }

    static public Method lookupMethodInInterfaces(Class[] ifaces, String name, String descriptor) {
        for (Class inface : ifaces) {
            for (Method method : inface.methods) {
                if (method.name.equals(name) && method.descriptor.equals(descriptor)) {
                    return method;
                }
            }
        }
        return null;
    }

}
