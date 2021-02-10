
package com.training.lambda.tp2;

public class LambdaRunnable {

	public static void main(String[] args) {
		/*
		Runnable oldRunnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("Ancienne méthode");
			}
		};
		oldRunnable.run();
		*/
		//en Java 8:
		Runnable oldRunnable = () ->  System.out.println("New Thread way");
		oldRunnable.run();

	}
}
