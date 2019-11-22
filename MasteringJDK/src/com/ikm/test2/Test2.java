package com.ikm.test2;

import java.util.stream.Stream;

public class Test2 {
    public static void main(String[] args) {
            Stream.of("little","red","riding","hood")
                    .parallel()
                    .map(s -> {
                        System.out.println("map: " + s + " " + Thread.currentThread().getName()); return s + "_" ;

                    }).filter(s -> {
                System.out.println("filter: " + s + " " + Thread.currentThread().getName()); return s.length() > 3 ;
            }).reduce((s1,s2) -> {
                System.out.println("reducer: " + s1 + " " + Thread.currentThread().getName());
                return s1.length() > s2.length()?s1:s2;
            });
    }
}

interface X {
    default void method1(){
        System.out.println("hello");
    }
}

abstract class A1 implements X{
    public abstract void method1();
}
