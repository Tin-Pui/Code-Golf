package com.codegolf.team0.challenge_a;

import java.util.ArrayList;
import java.util.List;

/**
 * Challenge A - Nth Prime
 * What is the Nth prime number?
 */
public class Team0_Q1 {

    public static void main(String[] args) {
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
        System.out.println("100000th prime number is " + findPrimeNumber(100000));
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
                // check divisability by primes (in ascending order) of currentInteger
                if (prime > max){
                    // currentInteger is a prime number
                    break;
                }
                if (prime <= max && currentInteger%prime==0) {
                    // currentInteger is not a prime number
                    currentIntegerIsPrime = false;
                    break;
                }
            }
            if (currentIntegerIsPrime) {
                primes.add(currentInteger);
            }
            // only check the primality of odd numbers
            currentInteger += 2;
        } while (primes.size() < primeIndex);
        return primes.get(primeIndex-1);
    }
}
