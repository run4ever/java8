package com.training.datetime.tp4;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class CalculDureeTravail {

    public static void main(String[] args) {

//        Nous considérons une application de gestion de temps, qui récolte les informations suivantes:
//        Date et heure d’arrivée le matin (27/04/17 à 09:29:30)
//        Date et heure de départ le soir (27/04/17 à 18:25:24)
//        Date et heure de début déjeuner (27/04/17 à 12:30:30)
//        Date et heure de fin de déjeuner (27/04/17 à 13:20:14)
//        La Durée de pause est de 20 min sur la journée
//        En utilisant l’API Date & Time, calculer la durée effective travaillée qui se définit comme suit:
//            dureeGlobale – dureeDejeuner - dureePause
//        Avec:
//            dureeGlobale = Date et heure de départ le soir - Date et heure d’arrivée le matin
//                dureeDejeuner = Date et heure de fin de déjeuner - Date et heure de début déjeuner

        LocalDateTime arrivedAt = LocalDateTime.parse("2017-04-27T09:29:30");
        //ou
        LocalDateTime arrivedAt2 = LocalDateTime.of(2017, Month.APRIL, 27, 9, 29, 30);

        LocalDateTime leftAt = LocalDateTime.parse("2017-04-27T18:25:24");
        LocalDateTime lunchStart = LocalDateTime.parse("2017-04-27T12:30:30");
        LocalDateTime lunchEnd = LocalDateTime.parse("2017-04-27T13:20:14");


        Duration globalDuration = Duration.between(arrivedAt, leftAt);
        Duration lunchDuration = Duration.between(lunchStart, lunchEnd);
        System.out.println("Durée globale : "+globalDuration.toMinutes()+" min. ");
        System.out.println("Durée du dej : "+lunchDuration.toMinutes()+" min. ");

        Long pauseEnMinutes = 20L;
        Duration effectiveWorkDuration = globalDuration.minus(lunchDuration).minus(pauseEnMinutes, ChronoUnit.MINUTES);
        //ou
        final Duration pause = Duration.ofMinutes(20);
        Duration effectiveWorkDuration2 = globalDuration.minus(lunchDuration).minus(pause);

        System.out.println("Durée effective de travail : "
                + effectiveWorkDuration2
        );


    }

}
