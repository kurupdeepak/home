package com.jukebox.solutions;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
;
public class LastElementList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(56, 24, 35, 11, 22, 100, 78, 54, 23, 32, 67, 89);
        System.out.println(list.get(list.size()-1));
    }
}
