package com.xi.day3.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * 构建流
 */
public class C04BuildTest {
    public static void main(String[] args) {

        // 1. 从集合构建
        List.of(1, 2, 3).stream().forEach(System.out::println);
        Set.of(1, 2, 3).stream().forEach(System.out::println);
        Map.of("a", 1, "b", 2).entrySet().stream().forEach(System.out::println);

        // 2. 从数组构建
        int[] array = {1, 2, 3};
        Arrays.stream(array).forEach(System.out::println);

        // 3. 从对象构建
        Stream.of(1,2,3,4,5).forEach(System.out::println);
    }
}
