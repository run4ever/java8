package com.training.datetime.tp1;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class CalculDuration {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Ancienne methode....");
		long start = System.currentTimeMillis();
		Thread.sleep(2000);
		long end = System.currentTimeMillis();
		System.out.println("Took : " + ((end - start) / 1000) + " sec");

//		La classe CalculDuration, affiche la durée globale d’ exécution en millisecondes
//		Convertir le calcul de la durée d’exécution de la classe en passant par les nouvelles API Java 8
//				- Instant
//				- Duration
		System.out.println("Nouvelle methode....");
		Instant time1=Instant.now();
		Thread.sleep(2000);
		Instant time2=Instant.now();
		System.out.println("Sieste de " + Duration.between(time1,time2).toMillis() + " millisec");



	}

}
