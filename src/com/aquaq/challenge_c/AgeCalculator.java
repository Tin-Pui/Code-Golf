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
        return period.getYears() + "," + period.getMonths() + "," + period.getDays();

    }

    /*public double findAge(String birthDate) throws ParseException {
        DateFormat birthdayFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date birthday = birthdayFormat.parse(birthDate);
        long totalMilliseconds = 0;
        if (birthday.getTime() < Calendar.getInstance().getTimeInMillis()) {
            totalMilliseconds = (Calendar.getInstance().getTimeInMillis() - birthday.getTime());
        } else {
            totalMilliseconds = birthday.getTime() - Calendar.getInstance().getTimeInMillis();
        }

        return (double) totalMilliseconds / 31556952000L;

    }

    public double findAgeShortened(int y, int m, int d) {
        return System.currentTimeMillis()-new Calendar.Builder().setDate(y, m, d).build().getTimeInMillis()/31556952000L;
    }*/
}
