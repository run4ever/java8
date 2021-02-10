package com.training.stream.tp2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamCollect2 {

//	Sur la classe StreamCollect2, remplacer dans la méthode collect:
//	Les références de méthode par des expressions lambda

	public static void main(String[] args) {
		String[] strings = { "a", "b", "c", "d", "e" };
		Stream<String> stream2 = Stream.of(strings);
		//List<String> list2 = stream2.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		//la 1ère lambda va regrouper a & b et c & d en // puis la 2ème va regroupers les 2 chaines resultantes
		List<String> list2 = stream2.collect(() -> new ArrayList<>(), (a1, a2) -> a1.add(a2), (a3, a4) -> a3.addAll(a4));

		list2.forEach(System.out::print);
	}
}