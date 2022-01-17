package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParallelMonteCarloPi {

    static class CountRunnable implements Runnable {
        @Override
        public void run() {
            long localCounter = 0;
            long iterations = counters.getIterations_for_one();
            for (long i = 0; i < iterations; i++) {
                if (Math.sqrt(Math.pow(Math.random(), 2) + Math.pow(Math.random(), 2)) <= 1) {
                    localCounter++;
                }
                if (i < 5) {
                    System.out.println("Iteration: " + i + "\nIterations: " + iterations);
                }
                else if (i == 400000) { System.out.println("Time: " + (startTime - System.currentTimeMillis()));}
            }
            counters.addToCounter(localCounter);
        }
    }

    static class Counters {
        long counter = 0;
        static final long iterations = 1000000;
        long iterations_for_one;
        long remainder;

        void setIterations_for_one(int num_of_threads) {
            iterations_for_one = iterations/num_of_threads;
            remainder = iterations % num_of_threads;
        }
        long getIterations_for_one() {
            synchronized (this) {
                if (remainder > 0) {
                    remainder--;
                    return iterations_for_one + 1;
                }
                else return iterations_for_one;
            }
        }
        void addToCounter(long localCounter) {
            synchronized (this) {
                this.counter += localCounter;
            }
        }
        double getResult() { return 4.0 * counter / iterations; }
    }
    static volatile Counters counters;
    static long startTime;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of threads: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Wrong value! Enter number of threads: ");
            scanner.next();
        }
        int num = Math.max(scanner.nextInt(), 1);

        counters = new Counters();
        counters.setIterations_for_one(num);

        CountRunnable cr = new CountRunnable();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            threads.add(new Thread(cr));
            threads.get(i).start();
        }
        startTime = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            try { threads.get(i).join(); }
            catch (InterruptedException e) { System.out.print(e); }
        }
        long finalTime = System.currentTimeMillis();
        System.out.println("PI: " + counters.getResult());
        System.out.println("Threads: " + num);
        System.out.println("Iterations: " + counters.iterations);
        System.out.println("Time: " + (finalTime - startTime) + "ms.");
    }
}
