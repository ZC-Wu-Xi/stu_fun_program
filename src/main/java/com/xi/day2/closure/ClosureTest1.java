package com.xi.day2.closure;

/**
 * 闭包
 */
public class ClosureTest1 {

    @FunctionalInterface
    interface Lambda {
        int op(int y);
    }

    static void highOrder(Lambda lambda) {
        System.out.println(lambda.op(1));
    }

    public static void main(String[] args) {
        /*
            函数对象 (int y) -> x + y 与它外部的变量 x 形成了闭包

            effective final
         */
//        int x = 10;
//        highOrder((int y) -> x + y); // 11
//        // x = 20; // 编译错误 使highOrder((int y) -> x + y); 报错，x是final的

        Student stu = new Student(20);
        Lambda lambda = y -> y + stu.d;
////        stu = new Student(30); // Lambda lambda = y -> y + stu.d; 报错
//        stu.d = 30; // 31 Lambda lambda = y -> y + stu.d;正常
        highOrder(lambda);

        stu.d = 40;
        highOrder(lambda); // 41 对象的引用变量可以变化 函数的不可变性被破坏了 违背了函数式编程 但这种做法也有它的应用场景
    }

    static class Student {
        int d;

        public Student(int d) {
            this.d = d;
        }
    }

    static int a = 1;
    int b = 2;

    public void test(int c) {
        highOrder(y -> a + y);
        highOrder(y -> b + y);
        highOrder(y -> c + y);
    }
}
