
package com.training.lambda.tp2;

public class LambdaThread {

	public static void main(String[] args) {
		Thread oldThread = new Thread(() -> System.out.println("Nouvelle méthode"));
		oldThread.start();
	}
}
