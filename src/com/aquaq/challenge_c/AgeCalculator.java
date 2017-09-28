package com.aquaq.challenge_c;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class AgeCalculator {

    public static void main(String[] args) {
        System.out.println("Get years: " + getAge(1992, Month.AUGUST, 4).getYears());
    }

    public static Period getAge(Integer year, Month month, Integer day) {
        return Period.between(LocalDate.of(year, month, day),  LocalDate.now());
    }

}
