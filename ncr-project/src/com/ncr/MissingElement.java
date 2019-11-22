package com.ncr;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MissingElement {
    public static void main(String[] args) {
        List<Integer> first =  Arrays.asList(4, 1, 0, 2, 9, 6, 8, 6, 7, 5, 3);
        List<Integer> second =  Arrays.asList(6, 4, 7, 2, 1, 0, 8, 3, 6, 9);
        List<Integer> f = first.stream().sorted().collect(Collectors.toList());
        List<Integer> s = second.stream().sorted().collect(Collectors.toList());
        System.out.println("Size of first " + f.size() + ", second" + s.size());
        int index = 0;
        int missing = 0;
        for(Integer v : f){
                if(index >= s.size()){
                    break;
                }
                if(v != s.get(index++)){
                    missing = v;
                    break;
                }
        }
        System.out.println(missing);
    }
}
