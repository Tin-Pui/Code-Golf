package com.aquaq.challenge_c;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class AgeCalculator {

    public static void main(String[] args) {

        LocalDate date = LocalDate.of(1984, Month.FEBRUARY, 4);

        String result = String.format("Years: %d, months: %d, days: %d",
                getAge(date).getYears(), getAge(date).getMonths(), getAge(date).getDays());
        System.out.println(result);
    }

    private static Period getAge(LocalDate date) {
        return Period.between(date, LocalDate.now());
    }

}
