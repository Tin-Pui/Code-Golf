package com.aquaq.challenge_b;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.*;

public class PresidentBirthdayCalculator {

    private String csvFile = "src/resources/presidents.csv";

    public static void main(String[] args) {
        PresidentBirthdayCalculator calculator = new PresidentBirthdayCalculator();

        try {
            List<LocalDate> birthList = calculator.readDates(1);
            List<LocalDate> deathList = calculator.readDates(3);

            LocalDate thresholdDate = LocalDate.of(1846, Month.JANUARY, 1);

            System.out.println("Presidents alive at specified date: "
                    + calculator.countPresidentsAlive(thresholdDate, birthList, deathList));

            List<String> presidentResults = calculator.countMostEverAlive(birthList, deathList);

            for (String result : presidentResults) {
                System.out.println(result);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    // part A
    public Integer countPresidentsAlive(
            LocalDate thresholdDate, List<LocalDate> birthList, List<LocalDate> deathList) throws IOException {
        int presidentsAlive = 0;
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

    public List<LocalDate> readDates(int column) throws IOException {

        List<LocalDate> dateList = new ArrayList<>();
        CSVReader csvReader = new CSVReader(new FileReader(csvFile));

        String[] nextLine;

        csvReader.readNext();
        while ((nextLine = csvReader.readNext()) != null && !nextLine.equals("")) {
            dateList.add(dateParser(nextLine[column]));
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

            }
        }

        return null;

    }

    // part B - also prints the answer to part C
    public List<String> countMostEverAlive(List<LocalDate> birthList, List<LocalDate> deathList) throws IOException {
        List<String> livingCountList = new ArrayList<>();

        int currentCountAlive = 0;
        int maxNumberAlive = 0;
        int birthCounter = 0;
        int deathCounter = 0;

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

        livingCountList = retrieveHighestCount(livingCountList, maxNumberAlive);

        return livingCountList;

    }

    public List<String> retrieveHighestCount(List<String> livingCountList, int highestCount) {
        for (int i = 0; i < livingCountList.size(); i++) {
            String[] totalCount = livingCountList.get(i).split(",");
            if (Integer.valueOf(totalCount[0]) != highestCount) {
                livingCountList.remove(i);
                i--;
            }
        }
        return livingCountList;
    }

}