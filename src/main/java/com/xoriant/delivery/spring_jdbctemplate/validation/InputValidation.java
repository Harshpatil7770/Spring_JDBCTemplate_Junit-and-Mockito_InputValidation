package com.xoriant.delivery.spring_jdbctemplate.validation;

import java.util.*;

public class InputValidation {

	private static Scanner sc = new Scanner(System.in);

	public static int inputIntegerValidation() {
		int number;
		do {
			System.out.println("Enter the number :: ");
			while (!sc.hasNextInt()) {
				System.out.println("That's not number ! \nEnter the number ::");
				sc.next();
			}
			number = sc.nextInt();
		} while (number <= 0);
		return number;

	}

	public static String inputStringValidation() {
		while (!sc.hasNext("[A-Za-z]*")) {
			System.out.println("That's not an alphabets !\n" + " Please enter an Alpabets :: ");
			sc.next();
		}
		String stundentName = sc.next();
		return stundentName;
	}

	public static double inputDoubleValidation() {
		double price;
		do {
			System.out.println("Enter the number :: ");
			while (!sc.hasNextDouble()) {
				System.out.println("That's not number ! \n Enter the number :: ");
				sc.next();
			}
			price = sc.nextDouble();
		} while (price <= 0);
		return price;

	}
}
