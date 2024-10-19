package com.xi.day2.hiorder;

import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

/**
 * 高阶函数
 * 内循环
 */
public class C01InnerLoop {

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);
        // 需求：逆序遍历集合，只想负责元素处理，不改变集合
        hiOrder(list, (value) -> System.out.println(value));
    }

    public static <T> void hiOrder(List<T> list, Consumer<T> consumer) {
        // 拿到集合的迭代器  定位到集合的最后
        ListIterator<T> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()) { // 判断是否有前一个元素
            T value = iterator.previous();
            consumer.accept(value); // 处理逻辑
        }
    }
}
