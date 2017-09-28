package com.codegolf.team0.challenge_c;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

/**
 * Challenge C  - How old am I?
 * Write a function/routine that given a date and the day someone was born, calculates how old they are.
 */
public class Team0_Q3 {

    public static void main(String[] args) {
        System.out.println(getAge(1983, Month.FEBRUARY, 10));
    }

    public static String getAge(Integer year, Month month, Integer day) {
        Period period = Period.between(LocalDate.of(year, month, day),  LocalDate.now());
        return period.getYears() + " yr, " + period.getMonths() + " m, " + period.getDays() + " d";
    }
}
