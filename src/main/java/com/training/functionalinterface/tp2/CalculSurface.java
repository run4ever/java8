package com.training.functionalinterface.tp2;

import java.util.function.BiFunction;

public class CalculSurface {

//	Soit la fonction f, qui calcule la surface d’un rectangle:
//	f(L,l)= L x l
//			Avec
//	l: Largeur de type décimal
//	L: Longueur de type décimal
//	Créer un package:
//	com.training.functionalinterface.tp2
//	Créer une classe:
//	CalculSurface
//	Ecrire un programme qui affiche la surface en passant par l’interface fonctionnelle BiFunction

	public static void main(final String[] args) {
		// TODO
		final BiFunction<Float, Float, Float> surfaceRect = (largeur, longueur) -> largeur * longueur;
		//comme les 3 sont du meme type, on peut écrire BiFunction<Float> ...
		Float resultat = surfaceRect.apply(1.5f,3f);
		System.out.println(resultat);
	}

}