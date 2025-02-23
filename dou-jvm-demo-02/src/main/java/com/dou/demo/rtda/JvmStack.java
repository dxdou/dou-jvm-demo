package com.dou.demo.rtda;

/**
 * @Author: dxdou
 * @Date: 2025/02/18/19:52
 * 虚拟机栈
 */
public class JvmStack {

    private int maxSize;
    private int size;
    private Frame _top;

    public JvmStack(int maxSize) {
        this.maxSize = maxSize;
    }

    public void push(Frame frame) {
        if (this.size > this.maxSize) {
            throw new StackOverflowError();
        }

        if (this._top != null) {
            frame.lower = this._top;
        }

        this._top = frame;
        this.size++;
    }

    public Frame pop() {
        if (this._top == null) {
            throw new RuntimeException("jvm stack is empty!");
        }

        Frame top = this._top;
        this._top = top.lower;
        top.lower = null;
        this.size--;

        return top;
    }

    public Frame top(){
        if (this._top == null){
            throw new RuntimeException("jvm stack is empty!");
        }
        return this._top;
    }

}
