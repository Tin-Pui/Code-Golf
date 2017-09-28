package com.codegolf.team0.challenge_a;

import java.util.ArrayList;
import java.util.List;

/**
 * Challenge A - Nth Prime
 * What is the Nth prime number?
 */
public class Team0_Q1 {

    public static void main(String[] args) {
        for (int primeIndex = 1; primeIndex <= 100; primeIndex+= 1) {
            System.out.println(findPrimeNumber(primeIndex));
        }
        int primeIndexToFind = 200000;
        long before = System.currentTimeMillis();
        int millionthPrime = findPrimeNumber(primeIndexToFind);
        long after = System.currentTimeMillis();
        System.out.println("The "+primeIndexToFind+"th prime is " + millionthPrime);
        System.out.println("Found in " + (after-before) + " ms");
    }

    public static int findPrimeNumber(final int primeIndex) {
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        int currentPrimeListSize = 1;
        int currentInteger = 3;
        do {
            if (integerIsPrime(currentInteger, primes)) {
                primes.add(currentInteger);
                currentPrimeListSize++;
            }
            currentInteger += 2;
        } while (currentPrimeListSize < primeIndex);
        return primes.get(primeIndex-1);
    }

    /**
     * Returns an integer's primality using a complete list of primes less than the integer.
     * @param integer
     * @param primes
     * @return
     */
    private static boolean integerIsPrime(final int integer, final List<Integer> primes) {
        boolean isPrime = true;
        boolean primalityDetermined = false;
        double maxCheck = Math.sqrt(integer);
        int primeListSize = primes.size();
        for (int index = 0; !primalityDetermined && index < primeListSize; index++) {
            int prime = primes.get(index);
            if (prime > maxCheck) {
                primalityDetermined = true;
            } else if (integer%prime == 0) {
                isPrime = false;
                primalityDetermined = true;
            }
        }
        return isPrime;
    }

    private static void testAlgorithmSpeed(final int sampleSize) {
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
}
