package com.dou.demo.instructions.base;

import com.dou.demo.rtda.Frame;
import com.dou.demo.rtda.Thread;
import com.dou.demo.rtda.heap.methodarea.Class;
import com.dou.demo.rtda.heap.methodarea.Method;

/**
 * @Author: dxdou
 * @Date: 2025/02/21
 */
public class ClassInitLogic {

    public static void initClass(Thread thread, Class clazz) {
        clazz.startInit();
        scheduleClinit(thread, clazz);
        initSuperClass(thread, clazz);
    }

    private static void scheduleClinit(Thread thread, Class clazz) {
        Method clinit = clazz.getClinitMethod();
        if (null == clinit) return;
        Frame newFrame = thread.newFrame(clinit);
        thread.pushFrame(newFrame);
    }

    private static void initSuperClass(Thread thread, Class clazz) {
        if (clazz.isInterface()) return;
        Class superClass = clazz.superClass();
        if (null != superClass && !superClass.initStarted()) {
            initClass(thread, superClass);
        }
    }

}
