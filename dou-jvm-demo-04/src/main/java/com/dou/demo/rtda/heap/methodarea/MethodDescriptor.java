package com.dou.demo.rtda.heap.methodarea;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: dxdou
 * @Date: 2025/02/21
 */
public class MethodDescriptor {

    public List<String> parameterTypes = new ArrayList<>();
    public String returnType;

    public void addParameterType(String type){
        this.parameterTypes.add(type);
    }

}
