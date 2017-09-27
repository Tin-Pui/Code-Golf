package com.aquaq.challenge_b;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class PresidentBirthdayCalculator {

    private String csvFile = "src/resources/presidents.csv";

    public static void main(String[] args) {
        PresidentBirthdayCalculator calculator = new PresidentBirthdayCalculator();
        Date testDate = new GregorianCalendar(1820, Calendar.JANUARY, 1).getTime();
        //System.out.println("Presidents alive at specified date: " + calculator.countPresidentsAlive(testDate));


        List<String> results = calculator.countMostEverAlive();
        for (String result : results) {
            System.out.println(result);
        }
    }

    public List<Date> readDate(int col) {

        List<Date> dateList = new ArrayList<>();
        CSVReader csvReader = null;
        try {
            csvReader = new CSVReader(new FileReader(csvFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String[] nextLine;
        try {
            csvReader.readNext();
            while ((nextLine = csvReader.readNext()) != null) {
                dateList.add(dateParser(nextLine[col]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dateList;
    }

    public static Date dateParser(String date) {
        List<String> stringFormats = Arrays.asList("y-M-d", "d/M/y");

        for (String format : stringFormats) {
            try {
                return new SimpleDateFormat(format).parse(date);
            } catch (ParseException e) {
            }
        }
        return null;
    }

    // part A
    public Integer countPresidentsAlive(Date thresholdDate) {

        int presidentsAlive = 0;
        List<Date> birthList = readDate(1);
        List<Date> deathList = readDate(3);

        int counter = 0;

        while (counter < birthList.size()) {
            if (birthList.get(counter).compareTo(thresholdDate) >= 1) {
                break;
            }

            if (birthList.get(counter).compareTo(thresholdDate) <= 1) {
                if (deathList.get(counter) != null) {
                    if (deathList.get(counter).compareTo(thresholdDate) >= 1) {
                        presidentsAlive++;
                    }
                } else {
                    presidentsAlive++;
                }
            }
            counter++;
        }

        return presidentsAlive;
    }

    // part B - also prints the answer to part C
    public List<String> countMostEverAlive() {

        List<String> livingCountList = new ArrayList<>();

        String yearRange = "";

        int currentCountAlive = 0;
        int maxNumberAlive = 0;

        int birthCounter = 0;
        int deathCounter = 0;

        List<Date> birthList = readDate(1);
        List<Date> deathList = readDate(3);

        birthList = sortDatesAscending(birthList);
        deathList = sortDatesAscending(deathList);

        while (birthCounter != birthList.size()) {
            if (birthList.get(birthCounter).compareTo(deathList.get(deathCounter)) < 1) {
                currentCountAlive++;
                birthCounter++;
            } else {
                currentCountAlive--;
                deathCounter++;
            }
            if (currentCountAlive >= maxNumberAlive) {
                maxNumberAlive = currentCountAlive;
                LocalDate yearStart = birthList.get(birthCounter - 1).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int yearRangeStart = yearStart.getYear();
                LocalDate yearEnd = deathList.get(deathCounter).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int yearRangeEnd = yearEnd.getYear();
                yearRange = currentCountAlive + "," + yearRangeStart + "," + yearRangeEnd;
                livingCountList.add(yearRange);
            }
        }

        for (int i = 0; i < livingCountList.size(); i++) {
            String[] totalCount = livingCountList.get(i).split(",");
            if (Integer.valueOf(totalCount[0]) != maxNumberAlive) {
                livingCountList.remove(i);
                i--;
            }
        }

        return livingCountList;
    }

    // part B
    public List<Date> sortDatesAscending(List<Date> datesToSort) {
        Collections.sort(datesToSort, new Comparator<Date>() {
            public int compare(Date date1, Date date2) {
                if (date1 == null || date2 == null)
                    return 0;
                return date1.compareTo(date2);
            }
        });
        return datesToSort;
    }

}