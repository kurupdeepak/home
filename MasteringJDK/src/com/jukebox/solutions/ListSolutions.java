package com.jukebox.solutions;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
;
public class ListSolutions {
    public static void main(String[] args) {
//        lastElement();
//        averageOfListValues();
        findIfExists(92);
    }




    static void lastElement(){
        List<Integer> list = Arrays.asList(56, 24, 35, 11, 22, 100, 78, 54, 23, 32, 67, 89);
        System.out.println(list.get(list.size()-1));
    }

    static void averageOfListValues(){
        List<Integer> list = Arrays.asList(56, 24, 35, 11, 22, 100, 78, 54, 23, 32, 67, 89);
        list.stream().mapToInt(a -> { return a;}).average().ifPresent(System.out::println);
//        System.out.println();
    }

    static void findIfExists(int num){
        List<Integer> list = Arrays.asList(56, 24, 35, 11, 22, 100, 78, 54, 23, 32, 67, 89);
        list.stream()
                .mapToInt(a -> {return a;})
                .filter(a -> a == num).collect();
    }
}


//Consumer,Function,Predicate,Supplier