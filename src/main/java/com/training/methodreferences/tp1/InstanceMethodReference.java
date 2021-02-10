package com.training.methodreferences.tp1;

import java.util.Arrays;
import java.util.List;

public class InstanceMethodReference {

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Orange", "Apple", "Banana");

        System.out.println("Afficher les fruits avec expressions lambda");
        fruits.forEach(x -> System.out.println(x));

        System.out.println("Afficher les fruits avec références de méthodes");
        fruits.forEach(System.out::println);

        System.out.println("Afficher les fruits en les triant alphabétiquement");
        //Il est possible de passer par la méthode compareToIgnoreCase de la classe String
        //fruits.sort((f1,f2) -> f1.compareToIgnoreCase(f2));
        fruits.sort(String::compareToIgnoreCase) ;
        fruits.forEach(System.out::println);

        System.out.println("Afficher les fruits en les triant alphabétiquement par ordre décroissant");
        //Il est possible de passer par la méthode compareToIgnoreCase de la classe String
        fruits.sort((f1,f2) -> - f1.compareToIgnoreCase(f2));
        fruits.forEach(System.out::println);

    }

}
