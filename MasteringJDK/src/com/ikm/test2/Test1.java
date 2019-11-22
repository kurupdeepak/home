package com.ikm.test2;

import java.util.Arrays;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("");
        int x = -1;
        System.out.println(x >> 1);
    }
}

class A{
    A(){

    }

    A(int n){

    }
}

class B extends  A{
    public B() {
    }

    public B(int n) {
        System.out.println(1);

    }
}
