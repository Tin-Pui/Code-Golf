package com.aquaq.challenge_c;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class AgeCalculator {

    public static void main(String[] args) {

        System.out.println(getAge(1992, Month.AUGUST, 4));
    }

    public static String getAge(Integer year, Month month, Integer day) {
        Period period = Period.between(LocalDate.of(year, month, day),  LocalDate.now());
        return period.getYears() + " yr, " + period.getMonths() + " m, " + period.getDays() + " d";

    }

}
