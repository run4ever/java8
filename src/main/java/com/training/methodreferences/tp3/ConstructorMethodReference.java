package com.training.methodreferences.tp3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.function.Supplier;

public class ConstructorMethodReference {

	public static Collection<Integer> arrayToCollection(Supplier<Collection<Integer>> supplier, Integer[] numbers) {
		Collection<Integer> collection = supplier.get();
		for (int i : numbers) {
			collection.add(i);
		}
		return collection;
	}

	public static void main(String[] args) {
		//Remplacer l’implémentation du Supplier Supplier<Collection<Integer>> supplier par une référence du constructeur ArrayList
		Integer[] array1 = { 1, 8, 5 };
/*
		Collection<Integer> col1 = arrayToCollection(() -> {
			return new ArrayList<>();
		}, array1);
		*/
		Collection<Integer> col1 = arrayToCollection(ArrayList<Integer>::new, array1);
		System.out.println("Natural order");
		col1.forEach(System.out::println);

		//Remplacer l’implémentation du Supplier Supplier<Collection<Integer>> supplier Par une référence de constructeur permettant d’avoir une liste triée
		Integer[] array2 = { 1, 8, 5 };
		//pour pouvoir trier on utilise HashSet
		Collection<Integer> col2 = arrayToCollection(HashSet<Integer>::new, array2);

		System.out.println("Sorted order");
		col2.forEach(System.out::println);


	}
}

