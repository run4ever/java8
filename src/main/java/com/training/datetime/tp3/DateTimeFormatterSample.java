package com.training.datetime.tp3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTimeFormatterSample {

    public static void main(String[] args) {

        final LocalDate today = LocalDate.now();
        final LocalDateTime todayWithTime = LocalDateTime.now();

//        En utilisant l’API DateTimeFormatter
//        Afficher la date du jour en utilisant le pattern: dd MMMM , yyyy HH:mm:ss
        DateTimeFormatter dateFormatter2 = DateTimeFormatter.ofPattern("dd MMMM, yyyy HH:mm:ss");
        System.out.println(dateFormatter2.format(todayWithTime));

//        Afficher la date du jour en passant par l’énumération FormatStyle.SHORT
        System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(today));



    }

}
