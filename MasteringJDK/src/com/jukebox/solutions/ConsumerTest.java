package com.jukebox.solutions;

import java.util.function.Consumer;
import java.util.stream.IntStream;

public class ConsumerTest {
    public static void main(String[] args) {
        Consumer<Integer> val = new Consumer<Integer>(){
            @Override
            public void accept(Integer integer) {
                System.out.println(integer + "-10");
            }
        };

        Consumer<Integer> val1 = a -> {
            System.out.println(a + "-15");
        };
        val.accept(5);
        val1.accept(18);
        IntStream.of(5,6,8).forEach(a -> {System.out.println(a + "-16");});

        IntStream.of(51,61,81).forEach(ConsumerTest::add16);

        IntStream.of(51,61,81).forEach(val1::accept);

    }

    static void add16(int val){
        System.out.println(val + "-18");
    }
}

