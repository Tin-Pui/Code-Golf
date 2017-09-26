package com.codegolf.team0.challenge_c;

import java.util.Calendar;

public class Team0_Q3 {

    public static void main(String[] args) {

    }

    public static double calculateAge(int day, int month, int year) {
        Calendar.Builder calendarBuilder = new Calendar.Builder().setDate(year, month, day);
        long birthTime = calendarBuilder.build().getTimeInMillis();
        long presentTime = System.currentTimeMillis();
        long millisecondsInYear = 31556926080L;
        return (presentTime - birthTime)/ (double)millisecondsInYear;
    }
}
