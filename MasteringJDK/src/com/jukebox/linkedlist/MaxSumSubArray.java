package com.jukebox.linkedlist;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class MaxSumSubArray {
    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        int l = Integer.parseInt(r.nextLine());
        String line2 = r.nextLine();
        String s[] = line2.split(" ");
        int arr[] = new int[l];
        for(int i = 0;i < s.length;i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        System.out.println(simpleSolution(arr));
    }

    static int simpleSolution(int a[]) {
        int largest = 0;
        int s = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                if (largest == 0 || s > largest) {
                    largest = s;
                    s = 0;
                    continue;
                }
            } else {
                s += a[i];
            }
        }
           return largest;
    }
}





