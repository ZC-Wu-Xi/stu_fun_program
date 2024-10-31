package com.xi.day3.stream;

import java.util.*;
import java.util.stream.Stream;


public class C11CollectTest {
    record Hero(String name, int strength) {

    }

    /*
        收集：将元素收集入容器
            .collect(() -> c, (c, x) -> void, ?)

            () -> c             创建容器 c
            (c, x) -> void      将元素 x 加入 容器 c
     */
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("令狐冲", "风清扬", "独孤求败", "方证",
                "东方不败", "冲虚", "向问天", "任我行", "不戒", "不戒", "不戒", "不戒");
        // 1) 收集到 List
//        List<String> result = stream.collect(() -> new ArrayList<>(), (list, x) -> list.add(x), (a, b) -> { });
      /*
      简化上述代码
         ArrayList::new   ()->new ArrayList()
         ArrayList::add   (list,x)->list.add(x)
      */
//            List<String> result = stream.collect(ArrayList::new, ArrayList::add, (a, b) -> { });

        // 2) 收集到 Set
//        Set<String> result = stream.collect(HashSet::new, Set::add, (a, b) -> {});
//        Set<String> result = stream.collect(LinkedHashSet::new, Set::add, (a, b) -> {});
//        for (String s : result) {
//            System.out.print(s + " ");
//        }

        // 3) 收集到 Map
//        Map<String, Integer> result = stream.collect(HashMap::new, (map, key) -> map.put(key, 1), (a, b) -> {});
//        for (Map.Entry<String, Integer> e : result.entrySet()) {
//            System.out.print(e + " "); // 令狐冲=1 冲虚=1 向问天=1 任我行=1 方证=1 独孤求败=1 东方不败=1 不戒=1 风清扬=1
//        }

        // 4) 收集到 StringBuffer
//        StringBuffer result = stream.collect(StringBuffer::new, (strBuffer, str) -> strBuffer.append(str + " "), (a, b) -> {});
//        System.out.println(result.toString()); // 令狐冲 风清扬 独孤求败 方证 东方不败 冲虚 向问天 任我行 不戒 不戒 不戒 不戒

        // 5) 收集到 StringBuilder
//        StringBuilder result = stream.collect(StringBuilder::new, StringBuilder::append, (a,b)->{});
//        System.out.println(result);


        // 6) 收集到 StringJoiner
        StringJoiner result = stream.collect(()->new StringJoiner(","), StringJoiner::add, (a,b)->{});
        System.out.println(result);
    }
}
