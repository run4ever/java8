package com.training.stream.tp7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExercice {

//    Produire une chaîne unique qui résulte de la concaténation des éléments du tableau en majuscules:
//    Ex., le résultat devrait être "HIHELLO ...".
//    Utilisez une seule opération de réduction, sans utiliser map.
//    Produire la même chaîne que ci-dessus, mais cette fois par une opération map qui transforme les mots en majuscule, suivie d'une opération de réduction qui les concatène.
//    Produire une chaîne concaténée tout les éléments de la liste, avec une virgule comme séparateur
//    Trouver le nombre total de caractères dans la liste, toutes chaines confondues.
//    Trouver le nombre de mots contenant un "h".

    public static void main(String[] args) {
        List<String> words = Arrays.asList("hi", "hello", "hola", "bye", "goodbye", "adios");

        Stream<String> stream = words.stream();
        stream.collect(() -> new ArrayList<>(), (a1, a2) -> a1.add(a2.toUpperCase()), (a3, a4) -> a3.addAll(a4))
                .forEach(System.out::print);

        System.out.println(
                words.stream().map(a -> a.toUpperCase()).reduce((a1, a2) -> a1.concat(a2)).toString()
        );

//    Produire une chaîne unique qui résulte de la concaténation des éléments du tableau en majuscules:
//    Ex., le résultat devrait être "HIHELLO ...".
//    Utilisez une seule opération de réduction, sans utiliser map.

        // le double quote correspond au 1er élément pour initialiser la variable de sortie
        final String upperCaseWords = words.stream().reduce("", (s1,s2) -> s1.toUpperCase() + s2.toUpperCase());
        final String upperCaseWords2 = words.stream().reduce("", String::concat).toUpperCase();
        System.out.printf("Uppercase words avec reduce : %s.%n", upperCaseWords);
        System.out.printf("Uppercase words avec reduce : %s.%n", upperCaseWords2);

        //    Produire la même chaîne que ci-dessus, mais cette fois par une opération map qui transforme les mots en majuscule, suivie d'une opération de réduction qui les concatène.
        final String upperCaseWords3 = words.stream().map(String::toUpperCase).reduce("",String::concat);
        System.out.printf("Uppercase words avec reduce : %s.%n", upperCaseWords3);
        final String upperCaseWords4 = words.stream().map(a -> a.toUpperCase()).reduce("",(s1,s2) -> s1 + s2);
        System.out.printf("Uppercase words avec reduce : %s.%n", upperCaseWords4);

        //    Produire une chaîne concaténée tout les éléments de la liste, avec une virgule comme séparateur
        // renvoie un optionnal donc get
        final String string5 = words.stream().reduce("", (s1,s2) -> s1 + "," + s2);
        System.out.printf("Uppercase words avec reduce : %s.%n", string5);
        final String string6 = words.stream().reduce((s1,s2) -> s1 + "," + s2).get();
        System.out.printf("Uppercase words avec reduce : %s.%n", string6);

        //    Trouver le nombre total de caractères dans la liste, toutes chaines confondues.
        System.out.printf("Nb char : %s.%n", words.stream().mapToInt(String::length).sum());

        //    Trouver le nombre de mots contenant un "h".
        final Long numHWord = words.stream().filter(s -> s.contains("h")).count();
        System.out.printf("Nb mots contenant h : %s.%n", numHWord);

    }

}
