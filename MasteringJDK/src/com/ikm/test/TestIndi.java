package com.jukebox.fp;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class TestIndi {
    public static void main(String[] args) {
        Stream.of(new Indices("Mercury"),new Indices("Venus"),new Indices("Earth"))
             .flatMap(i -> i.lists.stream()).mapToInt(j->j).max().ifPresent(s -> System.out.println(s));
    }
}

class Indices
{
    String s;
    List<Integer> lists;
    Indices(String s){
        this.s = s;
        lists  = new LinkedList<>();
        for(int i = 0  ; i < s.length() ; i++){
            lists.add(i);
        }
    }
}