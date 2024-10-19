package com.xi.day2.methodref;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用
 * 类名::new
 */
public class MethodRef4 {
    static class Student {
        private final String name;
        private final Integer age;

        public Student() {
            this.name = "某人";
            this.age = 18;
        }

        public Student(String name) {
            this.name = name;
            this.age = 18;
        }

        public Student(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
    interface Type51 {
        Student create();
    }

    interface Type52 {
        Student create(String name);
    }

    interface Type53 {
        Student create(String name, int age);
    }

    static void hiOrder(Type51 creator) {
        System.out.println(creator.create());
    }

    static void hiOrder(Type52 creator) {
        System.out.println(creator.create("张三"));
    }

    static void hiOrder(Type53 creator) {
        System.out.println(creator.create("李四", 20));
    }

    public static void main(String[] args) {
        hiOrder((Type51) Student::new); // 无参
        hiOrder((Type52) Student::new); // 一个参数
        hiOrder((Type53) Student::new); // 两个参数


        Supplier<Student> s1 = Student::new; // 无参
        Function<String, Student> s2 = Student::new; // 一个参数
        BiFunction<String, Integer, Student> s3 = Student::new; // 两个参数

        System.out.println(s1.get());
        System.out.println(s2.apply("张三"));
        System.out.println(s3.apply("李四", 25));
    }
}
