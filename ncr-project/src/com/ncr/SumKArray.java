package com.ncr;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SumKArray {

    public static void main(String[] args) {
        int [] a =  {1,1,2,3,4};

        int j = a.length - 1;
        int m = a.length/2;
        int  k = 4;
        Set<List<Integer>> result = new HashSet<>();

        for(int i = 0; i < a.length ; i ++ ){
            if(i != m && j > i ){
                if((a[i] + a[j])  == k){
                    result.add(Arrays.asList(a[i],a[j]));
                }
            }
            j--;
        }

        System.out.println(result);

    }
}
