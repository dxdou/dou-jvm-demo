package com.dou.demo;

import com.dou.demo.classpath.Classpath;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: dxdou
 * @Date: 2025/02/18/19:52
 * @Description:D:\Develop\code\study\dou-jvm-demo\dou-jvm-demo-01\target\test-classes\com\dou\demo\HelloWorld
 */
public class Main {
    public static void main(String[] args) {
        Cmd cmd = Cmd.parse(args);
        if (!cmd.ok || cmd.helpFlag) {
            System.out.println("Usage: <main class> [-options] class [args...]");
            return;
        }
        if (cmd.versionFlag) {
            System.out.println("java version \"1.8.0\"");
            return;
        }
        startJVM(cmd);
    }

    private static void startJVM(Cmd cmd) {
        Classpath classpath = new Classpath(null, cmd.getMainClass());
        try {
            byte[] classData = classpath.readClass(cmd.getMainClass());
            for (byte b : classData) {
                //16进制输出
                System.out.print(String.format("%02x", b & 0xff) + " ");
            }
            System.out.println();
            System.out.println("find class, data is " + Arrays.toString(classData));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
