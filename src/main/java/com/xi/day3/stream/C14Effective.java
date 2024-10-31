package com.xi.day3.stream;

import java.util.IntSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * 三种基本流
 */
public class C14Effective {
    record Hero(String name, int strength) {

    }
    /*
        三种基本流
     */
    public static void main(String[] args) {
        IntStream a = IntStream.of(97, 98, 99);
        LongStream b = LongStream.of(1L, 2L, 3L);
        DoubleStream c = DoubleStream.of(1.0, 2.0, 3.0);

        Stream<Integer> d = Stream.of(1, 2, 3);

        // 转换为字符串
//        a.mapToObj(Character::toString).forEach(System.out::print); // abc

//        IntSummaryStatistics stat = a.summaryStatistics();
//        System.out.println(stat.toString()); // IntSummaryStatistics{count=3, sum=294, min=97, average=98.000000, max=99}
//        System.out.println(stat.getSum());
//        System.out.println(stat.getCount());
//        System.out.println(stat.getMax());
//        System.out.println(stat.getMin());
//        System.out.println(stat.getAverage());

        Stream<Hero> stream = Stream.of(
                new Hero("令狐冲", 90),
                new Hero("风清扬", 98)
        );

        IntStream intStream = stream.mapToInt(Hero::strength);
        intStream.forEach(System.out::println);
    }
}
