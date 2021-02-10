package com.training.functionalinterface.tp1;

import java.util.function.Function;

public class MilesToKmConveter {

//	Soit la fonction f, qui converti la distance du Mile au Km:
//	f(d)= 1.6 x d
//	Avec
//	d: Distance en Miles de type décimal
//	Créer un package:
//	com.training.functionalinterface.tp1
//	Créer une classe:
//	MilesToKmConverter
//	Ecrire un programme qui affiche la conversion en Km, d’une distance en Miles, en passant par l’interface fonctionnelle Function
//  3 miles = 4,80 kilometers

	public static void main(final String[] args) {
		final int miles = 3;
		double kms = 0;

		// Avant JAVA 8
		//final Converter converter = new Converter();
		//kms = converter.apply(miles);

		// Depuis JAVA 8 - on utilise l'interface fonctionnelle fournie par Java8 qui ne contient qu'une methode apply
		final Function<Integer, Double> milesToKm = (input) -> input * 1.6;
		kms = milesToKm.apply(miles);

		//%d : résultat en décimal, %3.2f : variable sur 3 chiffres dont 2 decimales
		System.out.printf("%d miles = %3.2f kilometers", miles, kms);
	}

}