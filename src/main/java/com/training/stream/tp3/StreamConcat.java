package com.training.stream.tp3;

import java.util.stream.Stream;

//	Sur la classe StreamConcat, concaténer les streams stream1 et stream2
//	Afficher le résultat en passant par l’api Java 8

	public class StreamConcat {
		public static void main(String[] args) {
			Stream<String> stream1 = Stream.of("January", "Christie");
			Stream<String> stream2 = Stream.of("Okanagan", "Sydney", "Alpha");
			Stream<String> concat= Stream.concat(stream1, stream2);
			//solution sans tri
			// concat.forEach(System.out::println);
			//avec tri
			concat.sorted().forEach(System.out::println);
		}
	}