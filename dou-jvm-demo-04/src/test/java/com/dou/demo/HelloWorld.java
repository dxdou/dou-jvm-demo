package com.dou.demo;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: dxdou
 * @Date: 2025/02/18/20:03
 * @Description:
 */
public class HelloWorld {
    public static void main(String[] args) {
        long x = fibonacci(10);
        System.out.println(x);
    }

    //斐波那契数列（Fibonacci sequence）
    private static long fibonacci(long n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
