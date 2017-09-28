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
        LocalDate birthday = LocalDate.of(1983, Month.FEBRUARY, 10);
        String result = String.format("Years: %d, months: %d, days: %d",
                getAge(birthday).getYears(), getAge(birthday).getMonths(), getAge(birthday).getDays());
        System.out.println(result);
        System.out.println("(Total months: " + getAge(birthday).toTotalMonths() + ")");
    }

    private static Period getAge(LocalDate birthday) {
        return Period.between(birthday, LocalDate.now());
    }
}
