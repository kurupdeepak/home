package com.jukebox.threads;

import java.util.concurrent.*;

public class FutureVsCompletableFuture {
    public static void main(String[] args) {
        ExecutorService executor  = Executors.newFixedThreadPool(5);
        int val = 10;
        Future<Integer> result = executor.submit(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("I am still doing the work");
                Thread.sleep(5000);
                System.out.println("I am done with the work");
                return (val * val);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 0;
        });
        System.out.println("In the main method : step 1");
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("In the main method : step 2");
        executor.shutdown();
    }
}


