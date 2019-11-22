package com.ikm.test;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class SuppCons {
    static{
        System.out.println("Block1");
    }
    {
        System.out.println("Hello");
    }
    public static void main(String[] args) {
        System.out.println("Block2");
        new SuppCons();
        Supplier<String> i = () -> "Car";
        Consumer<String> c = x -> System.out.print(x.toLowerCase());
        Consumer<String> d = x -> System.out.print(x.toUpperCase());
        c.andThen(d).accept(i.get());
        System.out.println();
    }
}
