package com.training.stream.tp8;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeTP {

	static List<Employee> employees = new ArrayList<>();

	static {
		employees.add(new Employee(123, "Jack", "Johnson", LocalDate.of(1988, Month.APRIL, 12)));
		employees.add(new Employee(345, "Cindy", "Bower", LocalDate.of(2011, Month.DECEMBER, 15)));
		employees.add(new Employee(567, "Perry", "Node", LocalDate.of(2005, Month.JUNE, 07)));
		employees.add(new Employee(467, "Pam", "Krauss", LocalDate.of(2005, Month.JUNE, 07)));
		employees.add(new Employee(435, "Ann", "zee", LocalDate.of(1988, Month.APRIL, 17)));
		employees.add(new Employee(678, "Ann", "Stal", LocalDate.of(2007, Month.APRIL, 12)));
	}

	public static void main(String[] args) {

//		En utilisant l’API Stream
//		Afficher la liste des employées triées par numéro d’employée par ordre descendant
//		Afficher la liste des employées triées par nom puis par prénom

		System.out.println("avec stockage intermédiaire, ordre de numéro décroissant");
		List<Employee> sortedList = employees.stream()
				.sorted(Comparator.comparingInt(Employee::getEmployeeNumber).reversed())
				.collect(Collectors.toList());
		sortedList.forEach(System.out::println);

		System.out.println("sans stockage intermédiaire, ordre de numéro croissant");
		employees.stream()
				.sorted(Comparator.comparingInt(Employee::getEmployeeNumber))
				.collect(Collectors.toList())
				.forEach(System.out::println);

		// avec ecriture lambda
		employees.stream().sorted((e1,e2) -> Integer.compare(e1.getEmployeeNumber(), e2.getEmployeeNumber()))
				.forEach(System.out::println);

		//autre methode
		final Comparator<Employee> byNumComp = (e1,e2) -> Integer.compare(e1.getEmployeeNumber(), e2.getEmployeeNumber());
		employees.stream().sorted(byNumComp.reversed()).forEach(e -> System.out.println(e));

		System.out.println("sans stockage intermédiaire, ordre croissant de nom");
		employees.stream()
				.sorted(Comparator.comparing(Employee::getEmployeeLastName))
				.forEach(System.out::println);

		System.out.println("sans stockage, ordonné par prénom puis nom");
		employees.stream()
				.sorted(Comparator.comparing(Employee::getEmployeeFirstName)
						.thenComparing(Employee::getEmployeeLastName))
				.forEach(System.out::println);

		//autre méthode encore
		final Comparator<Employee> byFirst = (e1,e2) -> e1.getEmployeeFirstName().compareTo(e2.getEmployeeFirstName());
		final Comparator<Employee> byLast = (e1,e2) -> e1.getEmployeeLastName().compareTo(e2.getEmployeeLastName());
		employees.stream().sorted(byFirst.thenComparing(byLast)).forEach(e -> System.out.println(e));


	}

}
