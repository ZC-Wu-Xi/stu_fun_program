package com.xi.day3.stream;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class C13GroupingByTest {
    record Hero(String name, int strength) {

    }

    public static void main(String[] args) {
        Stream<Hero> stream = Stream.of(
                new Hero("令狐冲", 90),
                new Hero("风清扬", 98),
                new Hero("独孤求败", 100),
                new Hero("方证", 92),
                new Hero("东方不败", 98),
                new Hero("冲虚", 90),
                new Hero("向问天", 88),
                new Hero("任我行", 92),
                new Hero("不戒", 88)
        );

         // 1. mapping(x->y, dc)  需求：根据名字长度分组，分组后组内只保留他们的武力值
         //     new Hero("令狐冲", 90)->90
         //     dc 下游收集器 down collector
//        Map<Integer, List<Integer>> collect1 = stream.collect(groupingBy(h -> h.name().length(), mapping(h -> h.strength(), toList())));
//        System.out.println(collect1);

         // 2. filtering(x->boolean, dc)  需求：根据名字长度分组，分组后组内过滤掉武力小于 90 的
         // 在分组收集的过程中，执行过滤
//        Map<Integer, List<Hero>> collect2 = stream.collect(groupingBy(h -> h.name().length(), filtering(h -> h.strength() >= 90, toList())));
//        System.out.println(collect2);
        // 先过滤，再来分组收集
//        Map<Integer, List<Hero>> collect3 = stream.filter(h -> h.strength() >= 90).collect(groupingBy(h -> h.name().length(), toList()));
//        System.out.println(collect3);
         // 3. flatMapping(x->substream, dc)     需求：根据名字长度分组，分组后组内保留人名，并且人名切分成单个字符
//        "令狐冲".chars().forEach(System.out::println);
//        "令狐冲".chars().mapToObj(Character::toString).forEach(System.out::println);
//
//        Map<Integer, List<String>> collect4 = stream.collect(groupingBy(h -> h.name().length(),
//                flatMapping(h -> h.name().chars().mapToObj(Character::toString), toList())));
//        System.out.println(collect4);

         // 4. counting() 需求：根据名字长度分组，分组后求每组个数
//        Map<Integer, Long> collect5 = stream.collect(groupingBy(h -> h.name().length(), counting()));
//        System.out.println(collect5);

          // 5. minBy((a,b)->int) 需求：根据名字长度分组，分组后求每组武功最低的人
          // 6. maxBy((a,b)->int) 需求：根据名字长度分组，分组后求每组武功最高的人
//        Map<Integer, Optional<Hero>> collect6 = stream.collect(groupingBy(h -> h.name().length(), maxBy(Comparator.comparingInt(Hero::strength))));
//        System.out.println(collect6);

          // 7. summingInt(x->int)            需求：根据名字长度分组，分组后求每组武力和
          // 8. averagingDouble(x->double)    需求：根据名字长度分组，分组后求每组武力平均值
//        Map<Integer, Double> collect7 = stream.collect(groupingBy(h -> h.name().length(), averagingDouble(Hero::strength)));
//        System.out.println(collect7);

         // 9. reducing(init,(p,x)->r)
         // 求和
//        Map<Integer, Integer> collect8 = stream.collect(groupingBy(h -> h.name().length(), mapping(h -> h.strength(), reducing(0, (p, x) -> p + x))));
//        System.out.println(collect8); // {2=270, 3=368, 4=198}
        // 求个数
//        Map<Integer, Integer> collect9 = stream.collect(groupingBy(h -> h.name().length(), mapping(h -> 1, reducing(0, (p, x) -> p + x))));
//        System.out.println(collect9); // {2=3, 3=4, 4=2}

        // 求平均，缺少 finisher
        Map<Integer, double[]> collect = stream.collect(groupingBy(h -> h.name().length(),
                mapping(h -> new double[]{h.strength(), 1},
                        reducing(new double[]{0, 0}, (p, x) -> new double[]{p[0] + x[0], p[1] + x[1]}))));
        for (Map.Entry<Integer, double[]> e : collect.entrySet()) {
            System.out.println(e.getKey() + ":" + Arrays.toString(e.getValue()));
        }
    }
}
