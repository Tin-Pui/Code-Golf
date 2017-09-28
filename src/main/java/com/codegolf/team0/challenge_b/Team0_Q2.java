package com.codegolf.team0.challenge_b;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.*;

/**
 * Challenge B - Happy Birthday Mr. President
 * Attached a file with the birth and death dates of a list of people (in this case US presidents).
 * For any file formatted in a similar fashion as an input write logic to:
 * a) calculate how many entries where alive at a specific date
 * b) what is the most number of entries who've ever been alive at once?
 * c) what years did this happen?
 */
public class Team0_Q2 {

    public static void main(String[] args) {
        String csvFile = "src/resources/presidents.csv";
        System.out.println("Presidents alive at specified date: "
                + countPresidentsAlive(LocalDate.of(1846, Month.JANUARY, 1), csvFile));

        List<String> results = countMostEverAlive(csvFile);
        for (String result : results) {
            System.out.println(result);
        }

    }

    public static List<LocalDate> readDates(String csvFile, int column) {

        List<LocalDate> dateList = new ArrayList<>();
        CSVReader csvReader = null;
        try {
            csvReader = new CSVReader(new FileReader(csvFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String[] nextLine;
        try {
            csvReader.readNext();
            while ((nextLine = csvReader.readNext()) != null && !nextLine.equals("")) {
                dateList.add(dateParser(nextLine[column]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dateList;

    }

    public static LocalDate dateParser(String date) {
        List<String> stringFormats = Arrays.asList("y-M-d", "d/M/y");

        for (String format : stringFormats) {

            try {
                return new SimpleDateFormat(format).parse(date)
                        .toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            } catch (ParseException e) {
                // ignore exception and loop on
            }
        }

        return null;

    }

    // part A
    public static Integer countPresidentsAlive(LocalDate thresholdDate, String csvFile) {

        int presidentsAlive = 0;
        List<LocalDate> birthList = readDates(csvFile, 1);
        List<LocalDate> deathList = readDates(csvFile, 3);

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
    public static List<String> countMostEverAlive(String csvFile) {

        List<String> livingCountList = new ArrayList<>();

        int currentCountAlive = 0;
        int maxNumberAlive = 0;

        int birthCounter = 0;
        int deathCounter = 0;

        List<LocalDate> birthList = readDates(csvFile, 1);
        List<LocalDate> deathList = readDates(csvFile, 3);

        Collections.sort(birthList);

        deathList.removeAll(Collections.singleton(null));
        Collections.sort(deathList);

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
                LocalDate yearStart = birthList.get(birthCounter - 1);
                int yearRangeStart = yearStart.getYear();
                LocalDate yearEnd = deathList.get(deathCounter);
                int yearRangeEnd = yearEnd.getYear();
                String yearRange = currentCountAlive + ", between " + yearRangeStart + " and " + yearRangeEnd;
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
}
