package com.jukebox.fp;

public class LazyEvaluation {
    public static void main(String[] args) {
        Function<Integer,Integer> lazy1 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer i) {
                return i;
            }
        };
        System.out.println(true?lazy1.apply(10):lazy1.apply(20));
    }
}
