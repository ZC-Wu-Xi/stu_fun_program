package com.xi.day1;

// 要想成为合格函数：引用的外部数据必须是不可变的（除参数外）
public class Sample2 {

    public static void main(String[] args) {
        System.out.println(pray("张三"));
        System.out.println(pray("张三"));
        System.out.println(pray("张三"));
//        buddha.name = "魔王";
        System.out.println(pray("张三"));
    }

//    static class Buddha {
//        // String name; // name可变 pray()不是一个合格的函数
//        final String name;// 加一个final保证不可变
//
//        public Buddha(String name) {
//            this.name = name;
//        }
//    }

    /**
     * 补充：Java 16保证值不可变
     * record: 这是用来定义记录类型的Java关键字。记录类型是Java 16中引入的一个新特性，它提供了一种简洁的方式来定义不可变的数据类。
     * Buddha: 这是记录类型的名称。
     * String name: 这是记录中的一个字段，表示每个Buddha记录都会有一个类型为String的name字段。
     * {}: 这些大括号是记录体的占位符，通常会在其中定义记录的字段和方法。
     *
     * recored定义的不可变的数据类，name值不可变，保证pray()函数是一个合格的函数
     * @param name
     */
    record Buddha(String name) {}

    static Buddha buddha = new Buddha("如来");

    static String pray(String person) {
        return (person + "向[" + buddha.name + "]虔诚祈祷");
    }
}
