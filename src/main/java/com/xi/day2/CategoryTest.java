package com.xi.day2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;
import java.util.function.Supplier;

public class CategoryTest {

    static class Student {
        private String name;
        private String sex;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {
//        Type1 obj1 = a -> (a & 1) == 0;
//        Type1 obj2 = a -> BigInteger.valueOf(a).isProbablePrime(100);  // 检查一个整数是不是质数
//        Type2 obj3 = (a, b, c) -> a + b + c;
//        Type3 obj4 = (a, b) -> a - b;
//        Type3 obj5 = (a, b) -> a * b;
//
////        Type4 obj6 = () -> new Student();
////        Type5 obj7 = () -> new ArrayList<Student>();
//        Type6<Student> obj6 = () -> new Student();
//        Type6<List<Student>> obj7 = () -> new ArrayList<Student>();
//
//        Type7<String, Student> obj8 = (Student s) -> s.getName();
//        Type7<Integer, Student> obj9 = s -> s.getAge();
        // 使用jdk 提供的函数式接口
        IntPredicate obj1 = a -> (a & 1) == 0;
        IntPredicate obj2 = a -> BigInteger.valueOf(a).isProbablePrime(100);
        IntTernaryOperator obj3 = (a, b, c) -> a + b + c; // 自定义的
        IntBinaryOperator obj4 = (a, b) -> a - b;
        IntBinaryOperator obj5 = (a, b) -> a * b;
        Supplier<Student> obj6 = () -> new Student();
        Supplier<List<Student>> obj7 = () -> new ArrayList<Student>();
        Function<Student, String> obj8 = s -> s.getName();
        Function<Student, Integer> obj9 = s -> s.getAge();
    }

    @FunctionalInterface
    interface Type1 {
        boolean op(int a);
    }

    @FunctionalInterface
    interface Type2 {
        int op(int a, int b, int c);
    }

    @FunctionalInterface
    interface IntTernaryOperator {
        int op(int a, int b, int c);
    }

    @FunctionalInterface
    interface Type3 {
        int op(int a, int b);
    }

    @FunctionalInterface
    interface Type4 {
        Student op();
    }

    @FunctionalInterface
    interface Type5 {
        List<Student> op();
    }

    @FunctionalInterface
    interface Type6<T> {
        T op();
    }

    @FunctionalInterface
    interface Type7<O, I> {
        O op(I input);
    }
}
