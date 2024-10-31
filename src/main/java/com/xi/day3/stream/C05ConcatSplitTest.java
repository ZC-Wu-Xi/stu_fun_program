package com.xi.day3.stream;

import java.util.stream.Stream;

/**
 * 流的合并与截取
 */
public class C05ConcatSplitTest {

    public static void main(String[] args) {
        // 1. 合并
        Stream<Integer> s1 = Stream.of(1, 2, 3);
        Stream<Integer> s2 = Stream.of(4, 5, 1, 2);

        Stream<Integer> concat = Stream.concat(s1, s2);


        /*
            2. 截取 - 直接给出截取位置
            skip(long n)            跳过前 n 个数据，保留剩下的
            limit(long n)           保留前 n 个数据，剩下的不要
         */
//        concat.skip(2).forEach(System.out::print);
//        concat.limit(2).forEach(System.out::print);
//        concat.skip(2).limit(2).forEach(System.out::print);

        /*
            1   2   3   4   5   1   2
         */

        /*
            3. 截取 - 根据条件确定截取位置
            takeWhile(Predicate p)      条件成立保留, 一旦条件不成立，剩下的不要
            dropWhile(Predicate p)      条件成立舍弃, 一旦条件不成立，剩下的保留
         */
        concat.takeWhile(x->x<3).forEach(System.out::print);
//        concat.dropWhile(x->x<3).forEach(System.out::print);
    }
}
