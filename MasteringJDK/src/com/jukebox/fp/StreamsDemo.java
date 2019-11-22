package com.jukebox.fp;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class StreamsDemo {

    public static void main(String[] args) {
        List<String> lst = Arrays.asList("One","Two","Three","Four");
        //display all elements
        System.out.println("ForEach");
        lst.forEach(System.out::println);
        System.out.println("Filter");
        //filter results
        lst.stream().filter((e) -> !e.equals("One")).forEach(System.out::println);
        System.out.println("Map");
        //map
        lst.stream().map((e) -> e.toUpperCase()).forEach(System.out::println);

        //Instead of display lets
        IntStream intStream = IntStream.range(1,100_000_000);
        long s = System.currentTimeMillis();
        int sum = intStream.filter((e) -> e > 9).reduce(0,(total, val) -> total + val);
        System.out.println("Sum = " + sum + ((System.currentTimeMillis() - s)/1000) + " s ");
    }
}
