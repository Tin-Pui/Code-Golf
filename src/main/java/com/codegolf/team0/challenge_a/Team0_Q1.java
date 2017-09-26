package com.codegolf.team0.challenge_a;

import java.util.ArrayList;
import java.util.List;

public class Team0_Q1 {

    public static void main(String[] args) {
        testAlgorithmSpeed(10);
        testAlgorithmSpeed(30);
    }

    private static void testAlgorithmSpeed(int sampleSize) {
        List<Long> times = new ArrayList<>();
        for (int i = 1; i<= sampleSize; i++) {
            long start = System.currentTimeMillis();
            findPrimeNumber(100000);
            long finish = System.currentTimeMillis();
            System.out.println(finish - start + " ms");
            times.add(finish-start);
        }
        long algorithm1 = 0;
        for (Long time : times) {
            algorithm1 += time;
        }
        System.out.println(findPrimeNumber(100000));
        System.out.println("average: "+ algorithm1/(times.size()) + " ms");
    }

    public static int findPrimeNumber(int primeIndex) {
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        int currentInteger = 3;
        boolean currentIntegerIsPrime;
        do {
            currentIntegerIsPrime = true;
            double max = Math.sqrt(currentInteger);
            for (int prime : primes) {
                if (prime > max){
                    break;
                }
                if (prime <= max && currentInteger%prime==0) {
                    currentIntegerIsPrime = false;
                    break;
                }
            }
            if (currentIntegerIsPrime) {
                primes.add(currentInteger);
            }
            currentInteger += 2;
        } while (primes.size() < primeIndex);
        return primes.get(primeIndex-1);
    }
}
