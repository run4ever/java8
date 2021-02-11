package com.training.datetime.tp2;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class LocalDateUtils {

//    En utilisant l’API LocalDate

    public static void main(String[] args) {
//    Afficher la date du jour: today
        LocalDate today = LocalDate.now();
        System.out.println(today);

//    Afficher le jour du mois courant
        System.out.println(today.getDayOfMonth()+" ème jour");

//    Afficher le nombre de jours du mois
        System.out.println(today.lengthOfMonth()+" jours dans ce mois");

//    Ajouter 1 jours à la date courante puis afficher le résultat: tomorrow
        LocalDate tomorrow = today.plusDays(1);
        System.out.println("Demain on sera : "+tomorrow);

//    Ajouter une décennie à la date courante puis afficher le résultat: nextDecade
        LocalDate nextDecade = today.plusYears(10);
        System.out.println("Et dans une décennie : "+nextDecade);
        //ou
        LocalDate nextDecade2 = nextDecade.plus(1, ChronoUnit.DECADES);
        System.out.println("Et dans 2 décennies : "+nextDecade2);


//    Calculer la période entre les deux derniers résultats: nextDecade et tomorrow
        final Period ecart = Period.between(tomorrow,nextDecade);
        System.out.println("Ecart : " + ecart.getYears() + " ans "
                + ecart.getMonths() + " mois "
                + ecart.getDays() + " jours");



    }
}
