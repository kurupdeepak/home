package com.jukebox.fp;

public class PureFunctions {
    public static void main(String[] args) {
        Function<Integer,Integer> pureFunction = new Function<Integer, Integer>() {
            //pure function
            @Override
            public Integer apply(Integer integer) {
                return integer * 10;
            }
        };

        System.out.println(pureFunction.apply(10));
    }
}

interface Function<T,R>{
    R apply (T t);
}
