package com.training.stream.tp5;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Dans la classe School, implémenter la méthode calculateAvgAge,
//qui permet de calculer l’age moyen des enseignants.


public class School {

	public static void main(String[] args) {
		School demo = new School();
		Teacher[] teachers = { new Teacher("Jimm", LocalDate.of(1982, Month.JANUARY, 1)),
				new Teacher("Beck", LocalDate.of(1986, Month.DECEMBER, 25)),
				new Teacher("Anna", LocalDate.of(1974, Month.JULY, 4)),
				new Teacher("James", LocalDate.of(1980, Month.SEPTEMBER, 1)) };
		double avgAge = demo.calculateAvgAge3(teachers);
		System.out.printf("Average teacher age : %2.2f\n", avgAge);
	}

	private double calculateAvgAge(Teacher[] teachers) {

		final Stream<Teacher> streamTeacher = Arrays.stream(teachers);
		final Stream<Period> periodStream = streamTeacher.map(teacher -> Period.between(teacher.getBirthday(), LocalDate.now()));
		double averageAge = periodStream.mapToLong(period -> period.getYears()).average().getAsDouble();
		return	averageAge;

		//autre solution
//		double ageMoyen = Arrays.stream(teachers)
//				.mapToInt(teacher -> Period.between(teacher.getBirthday(), LocalDate.now()).getYears())
//				.average().getAsDouble();
//		return ageMoyen;


	}

	private double calculateAvgAge2(Teacher[] teachers) {
		final Stream<Teacher> stream = Arrays.stream(teachers);
		final Double averageAge = stream.collect(Collectors.averagingDouble(t -> t.getAge()));
		return	averageAge;
	}

	private double calculateAvgAge3(Teacher[] teachers) {
		final Stream<Teacher> stream = Arrays.stream(teachers);
		final Double averageAge = stream.mapToLong(Teacher::getAge).average().getAsDouble();
		return	averageAge;
	}

}