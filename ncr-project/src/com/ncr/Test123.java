package com.ncr;

import java.util.function.Function;
import java.util.stream.IntStream;

public class Test123 {

    public static void main(String[] args) {
        IntStream intStream = IntStream.range(0,5);

        System.out.println(intStream.sum());
    }
}
