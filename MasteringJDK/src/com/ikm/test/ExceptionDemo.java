package com.jukebox.fp;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ExceptionDemo {
    public static void main(String[] args) {
//        Optional<String> b = Optional.ofNullable("");
//        System.out.println(b.get().length());
//
//        int x = 5;
//        System.out.println(x >> 1);
//        System.out.println(~x);
//        System.out.println(!x);
        /*List<String> l = Arrays.asList("One","Two","Three");
        Map<Integer,List<String>> names = l.stream().collect(Collectors.groupingBy(p -> p.length()));
        System.out.println(names);*/

//        Predicate<String> p1 = s -> s.compareTo
        Consumer<String> s;
        BiFunction<Integer,String,String> s1;
     }

     void display(){
        class D{
            public void meth(){
                d++;
            }
        }
        D d  = new D();
     }

    public ExceptionDemo() {
        this(10);
    }

    private int d ;

    public ExceptionDemo(int x) {
    }
}
