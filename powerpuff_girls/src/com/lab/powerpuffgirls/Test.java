package com.lab.powerpuffgirls;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Test {
    static Scanner scanner = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[] )  {
        long s = System.currentTimeMillis();
        int ingredients = 0;
        String unit [] = new String[ingredients],
                labQty[] = new String[ingredients];
        try {
            ingredients = Integer.parseInt(reader.readLine());
        unit = reader.readLine().split(" ");
        labQty = reader.readLine().split(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long max [] = new long[ingredients];
        long val = -1;
        for(int i = 0 ; i < ingredients;i++){
            long ut = Long.parseLong(unit[i]);
            long qt = Long.parseLong(labQty[i]);
            max[i] = qt/ut;
            if(val == -1){
                val = max[i];
            }else{
                if(val > max[i]){
                    val = max[i];
                }
            }
        }
        // Arrays.sort(max);
        System.out.println(val);
        System.out.println("Time taken " + ((System.currentTimeMillis() - s)/1000) + "s");
    }

    int findMin(long [] n,long val, int i){
        if(i == n.length)
            return 0;
        if(i==0)
        val = n[i];
//        else
//            n[i]
        return 0;
    }

    static String readLine() throws IOException {

       return reader.readLine();
    }
}
