package com.jukebox.fp;

import java.util.stream.Stream;

public class Inheritance {
    public static void main(String[] args) {
        /*for(final int i =9;i<100;i++){
            System.out.println(i);
        }*/

        System.out.println(Stream.of("green","yellow","blue").max((s1,s2) -> s1.compareTo(s2)).filter(s->s.endsWith("n")).orElse("yellow"));
    }
}

class A{
    protected Number meth(String val,boolean b){
    return null;
    }
}

class B extends A{
    @Override
    public Number meth(String val,boolean b){
return null;
    }
}
