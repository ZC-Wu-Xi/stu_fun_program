package com.xi.day2.currying;

/**
 * 柯里化
 * 柯里化的作用是让函数对象分步执行（本质上是利用多个函数对象和闭包）
 */
public class Carrying0Test {

    @FunctionalInterface
    interface F2 {
        int op(int a, int b);
    }

    // Fa返回另一个函数对象(帮我们收集参数b)
    @FunctionalInterface
    interface Fa {
        Fb op(int a);
    }

    @FunctionalInterface
    interface Fb {
        int op(int b);
    }

    public static void main(String[] args) {
        // 两个参数的函数对象
        F2 f2 = (a, b) -> a + b;
        System.out.println(f2.op(10, 20));

        /* 改造
            一次只接受一个参数，进行两参数相加
            (a) -> 返回另一个函数对象(帮我们收集参数b)
                    (b) -> a+b
         */
        // Fa fa = (a) -> Fb
        Fa fa = (a) ->
                (b) -> a + b; // (b) -> a + b是Fa的返回值Fb
        Fb fb = fa.op(10);
        int r = fb.op(20);
        System.out.println(r);
    }

}
