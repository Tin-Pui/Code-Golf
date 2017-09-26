package com.aquaq.challenge_a;


import java.util.ArrayList;
import java.util.List;

public class PrimeNumberCalculator {

    public static void main(String[] args) {
        PrimeNumberCalculator primeNumberCalculator = new PrimeNumberCalculator();

        long start = System.currentTimeMillis();
        System.out.println(primeNumberCalculator.findPrime(10000));
        long end = System.currentTimeMillis() - start;
        System.out.println(end + "ms");

    }

    public Integer findPrime(int primeIndex) {
        List<Integer> primeList = new ArrayList<>();
        primeList.add(2);
        primeList.add(3);
        Integer count = 4;
        while (primeList.size() <= primeIndex) {
            if (primeCheck(count)) {
                primeList.add(count);
            } count++;
        }
        return primeList.get(primeIndex - 1);
    }

    public boolean primeCheck(Integer valueToCheck) {
        for (int i = 2; i <= (int) Math.sqrt(valueToCheck); i++) {
            if (valueToCheck % i == 0) {
                return false;
            }
        } return true;
    }

}
