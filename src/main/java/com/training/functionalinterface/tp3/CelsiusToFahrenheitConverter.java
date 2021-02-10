package com.training.functionalinterface.tp3;

import java.util.function.IntToDoubleFunction;

public class CelsiusToFahrenheitConverter {
/**
//	Soit la fonction f, qui converti un degré Celsius en degré Fahrenheit:
//	f(t)= 1.8 x t + 32
//	Avec
//	t: Température en Celsius de type entier
//	Créer un package:
//	com.training.functionalinterface.tp3
//	Créer une classe:
//	CelsiusToFahrenheitConverter
//	Ecrire un programme qui affiche la température en passant par l’interface fonctionnelle IntToDoubleFunction
*/
	public static void main(final String[] args) {
		// TODO
		final IntToDoubleFunction maFonction = (x) -> 1.8 * x + 32;
		double resultat = maFonction.applyAsDouble(20);
		System.out.println(resultat);

	}

}