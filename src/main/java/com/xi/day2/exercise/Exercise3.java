package com.xi.day2.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.*;

/**
 * 把下列方法中，可能存在变化的部分，抽象为函数对象，从外界传递进来
 */
public class Exercise3 {

    public static void main(String[] args) {
        List<Integer> result = filter(List.of(1, 2, 3, 4, 5, 6), (Integer number) -> (number & 1) == 1);
        System.out.println(result);

        List<String> result1 = map(List.of(1, 2, 3, 4, 5), (Integer number) -> String.valueOf(number));
        System.out.println(result1);

        consume(List.of(1, 2, 3, 4, 5), number -> System.out.print(number + " "));

        System.out.println();

        List<Integer> result2 = supply(5, () -> ThreadLocalRandom.current().nextInt());
        for (Integer number : result2) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    static List<Integer> filter(List<Integer> list, Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : list) {
            // 筛选：判断是否是偶数，但以后可能改变筛选规则
//            if ((number & 1) == 0) { // number & 1 按位与运算，全为1才是1否则为0，偶数的二进制最后一位是0
//                result.add(number);
//            }
            if(predicate.test(number)) {
                result.add(number);
            }
        }
        return result;

        /*
            (Integer number) -> (number & 1) == 0
         */
    }

    static List<String> map(List<Integer> list, Function<Integer, String> function) {
        List<String> result = new ArrayList<>();
        for (Integer number : list) {
            // 转换：将数字转为字符串，但以后可能改变转换规则
//            result.add(String.valueOf(number));
            result.add(function.apply(number));
        }
        /*
            (Integer number) -> String.valueOf(number)
         */
        return result;
    }

    static void consume(List<Integer> list, Consumer<Integer> consumer) {
        for (Integer number : list) {
            // 消费：打印，但以后可能改变消费规则
//            System.out.println(number);
            consumer.accept(number);
        }
    }

    static List<Integer> supply(int count, IntSupplier supplier) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            // 生成：随机数，但以后可能改变生成规则
//            result.add(ThreadLocalRandom.current().nextInt());
            result.add(supplier.getAsInt());
        }
        return result;
    }
}
