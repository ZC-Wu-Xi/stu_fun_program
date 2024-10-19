package com.xi.day2.methodref;

import java.util.stream.Stream;

/**
 * 方法引用
 * this::非静态方法名
 */
public class MethodRef5 {
    public static void main(String[] args) {
        Util util = new UtilExt();
//        Util util = new Util();
        util.hiOrder(Stream.of(
                new Student("张无忌", "男"),
                new Student("周芷若", "女"),
                new Student("宋青书", "男")
        ));
    }

    record Student(String name, String sex) { }

    static class Util {
        private boolean isMale(Student stu) {
            return stu.sex().equals("男");
        }
        private boolean isFemale(Student stu) {
            return stu.sex().equals("女");
        }
        // 过滤男性学生并打印
        void hiOrder(Stream<Student> stream) {
            stream
//                    .filter(stu->this.isMale(stu))
                    .filter(this::isMale)
                    .forEach(System.out::println);
        }
    }

    static class UtilExt extends Util {
        // 过滤女性学生并打印
        void hiOrder(Stream<Student> stream) {
            stream
                    .filter(super::isFemale)
                    .forEach(System.out::println);
        }
    }
}
