package com.training.lambda.tp1;

public class MathOperationJava8 {

	public static void main(final String[] args) {
		// Ecriture Javba 8. Une seule méthode sur interface fonctionnelle donc pas besoin de la nommer
		MathOperation mathOperation = (a, b) -> a+b;
		final int d = mathOperation.sommer(1,3);
		System.out.println(d);

	}

}
