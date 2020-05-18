package com.host.jdk18;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * created by xiaoyao01  on 2020/5/14.
 **/
public class StreamTest {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1,2,3,5,3,2,1);
        List<String> collect = l.stream().map(item -> item + 10).map(String::valueOf).distinct().collect(Collectors.toList());

        List<String> ls = Arrays.asList("1 2 3 "," 2 3 4","5 6");
        ls.stream().flatMap(it-> Stream.of(it.split(" "))).collect(Collectors.toList());
    }
}
