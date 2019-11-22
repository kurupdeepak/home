package com.jukebox.fp;

public class Closures {

    public static void main(String[] args) {
        Function<Integer,Integer> fp10 = partialAdd(10);
        System.out.println(fp10.apply(20));
    }

    static Function<Integer,Integer> partialAdd(Integer i){
        Function<Integer,Integer> partial = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer i1) {
                return i + i1;
            }
        };
        return partial;
    }
}
