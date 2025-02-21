package com.dou.demo.instructions.base;

import com.dou.demo.rtda.Frame;
import com.dou.demo.rtda.Slot;
import com.dou.demo.rtda.Thread;
import com.dou.demo.rtda.heap.methodarea.Method;

/**
 * @Author: dxdou
 * @Date: 2025/02/21
 */
public class MethodInvokeLogic {

    public static void invokeMethod(Frame invokerFrame, Method method) {
        Thread thread = invokerFrame.thread();
        Frame newFrame = thread.newFrame(method);
        thread.pushFrame(newFrame);

        int argSlotCount = method.argSlotCount();
        if (argSlotCount > 0) {
            for (int i = argSlotCount - 1; i >= 0; i--) {
                Slot slot = invokerFrame.operandStack().popSlot();
                newFrame.localVars().setSlot(i, slot);
            }
        }

        //hack
        if (method.isNative()) {
            if ("registerNatives".equals(method.name())) {
                thread.popFrame();
            } else {
                throw new RuntimeException("native method " + method.name());
            }
        }
    }

}
