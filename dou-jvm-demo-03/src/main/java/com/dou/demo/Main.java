package com.dou.demo;

import com.dou.demo.classpath.Classpath;
import com.dou.demo.rtda.heap.ClassLoader;
import com.dou.demo.rtda.heap.methodarea.Class;
import com.dou.demo.rtda.heap.methodarea.Method;

/**
 * @Author: dxdou
 * @Date: 2025/02/20/13:52
 * D:\Develop\code\study\dou-jvm-demo\dou-jvm-demo-02\target\test-classes\com\dou\demo\HelloWorld
 */
public class Main {

    public static void main(String[] args) {
        Cmd cmd = Cmd.parse(args);
        if (!cmd.ok || cmd.helpFlag) {
            System.out.println("Usage: <main class> [-options] class [args...]");
            return;
        }
        if (cmd.versionFlag) {
            //注意案例测试都是基于1.8，另外jdk1.9以后使用模块化没有rt.jar
            System.out.println("java version \"1.8.0\"");
            return;
        }
        startJVM(cmd);
    }

    private static void startJVM(Cmd cmd) {
        Classpath classpath = new Classpath(cmd.jre, cmd.classpath);
        ClassLoader classLoader = new ClassLoader(classpath);
        //获取className
        String className = cmd.getMainClass().replace(".", "/");
        Class mainClass = classLoader.loadClass(className);
        Method mainMethod = mainClass.getMainMethod();

        Class stingClass = classLoader.loadClass("java/lang/String");
        if (null == mainMethod) {
            throw new RuntimeException("Main method not found in class " + cmd.getMainClass());
        }
        new Interpret(mainMethod);
    }

}
