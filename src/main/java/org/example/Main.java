package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        LocalDate today = LocalDate.now();
        LocalDate dateToTest = LocalDate.parse("2023-12-22");

        System.out.println(now);
        System.out.println(today);

        System.out.println(today.plusWeeks(2));

        isDate1BeforeDate2(today,dateToTest);
        System.out.println(calculateDifferenceInDays(today,dateToTest));


    }

    public static void isDate1BeforeDate2(LocalDate date1, LocalDate date2) {
        if(date1.isBefore(date2)) {
            System.out.println(date1 + " is before " + date2);
            return;
        }
        System.out.println(date1 + " is not before " + date2);
    }

    public static long calculateDifferenceInDays(LocalDate date1, LocalDate date2) {
        return ChronoUnit.DAYS.between(date1,date2);
    }
}