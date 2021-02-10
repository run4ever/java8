package com.training.stream.tp6;

import com.training.stream.tp5.School;
import com.training.stream.tp5.Teacher;

import java.nio.file.Path;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonStream {

//	En passant par l’API Stream:
//	- Trouver les personnes qui ont un nom Jeff
//	- Trouver l'âge maximal des personnes
//	- Convertir la liste de personnes en une Map avec comme clé l'âge et la valeur le nom de la personne
//	List<Person> vers Map<Integer, String>
//	Afficher tous les éléments de la Map en passant par les API java 8



	public static void main(String[] args) throws Exception {
		PersonStream demo = new PersonStream();

		List<Person> persons = Arrays.asList(new Person("Brian", 22), new Person("Jeff", 20), new Person("Jimmy", 40), new Person("Jeanine", 40));

		//le collect final remet le contenu du stream dans une collection
		//nécessaire car la stream ne stocke rien
		List<Person> jeffList = persons.stream().filter(p -> p.getName().equals("Jeff")).collect(Collectors.toList());
		jeffList.forEach(System.out::println);

		//solution sans stockage
		persons.stream().filter(p -> p.getName().equals("Jeff")).forEach(System.out::println);

		demo.getJeff(persons);
		demo.getJeff2(persons);
		System.out.println(demo.getOlder(persons));

		final OptionalInt max = persons.stream().mapToInt(p -> p.getAge()).reduce(Integer::max);
		System.out.println(max);
		persons.stream().filter(p -> p.getAge() == max.getAsInt() ).forEach(System.out::println);

		//récupérer les plus vieux en une seule fois (peu lisible)
		List<Person> oldPers = persons.stream()
				.collect(Collectors.groupingBy(Person::getAge, TreeMap::new, Collectors.toList()))
				.lastEntry().getValue();
		oldPers.forEach(System.out::println);


		//Convertir la liste de personnes en une Map avec comme clé l'âge et la valeur le nom de la personne
		//collect permet de passer d'une collection à une autre
		//si 2 personnes ont le meme age, seul la dernière apparaitra car clé unique (la 2ème écrase 1ère)
		//donc plante si 2 personnes ont le meme age
		final Map<Integer, String> map = persons.stream().collect(Collectors.toMap(Person::getAge,Person::getName));
		map.forEach((a,n) -> System.out.println("Key : "+a+" Value : "+n));


	}

	private void getJeff(List<Person> persons){
		Stream<Person> result = persons.stream()
				.filter(p -> p.getName().contains("Jeff"));
		result.forEach(System.out::println);
	}

	private void getJeff2(List<Person> persons) {
		Stream<Person> p = persons.stream()
				.filter(pers -> pers.toString().contains("Jeff"));
		p.forEach(System.out::println);
	}

	public Person getOlder(List<Person> persons) throws Exception {
		Person plusVieux = persons
				.stream()
				.max(Comparator.comparing(Person::getAge))
				.orElseThrow(Exception::new);
		return plusVieux;
	}






}