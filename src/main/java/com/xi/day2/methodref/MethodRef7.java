package com.xi.day2.methodref;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * 对于**无需返回值的函数接口**，例如Consumer和Runnable它们**可以配合有返回值的函数对象**使用
 */
public class MethodRef7 {
    public static void main(String[] args) {
        Consumer<Object> x = MethodRef7::print1;
        Function<Object, Integer> y = MethodRef7::print2;
        Consumer<Object> z = MethodRef7::print2; // 特例 一个参数有返回值的函数使用一个参数无返回值的函数接口接收
    }

    static void print1(Object obj) {
        System.out.println(obj);
    }

    static int print2(Object obj) {
        System.out.println(obj);
        return 1;
    }
}
