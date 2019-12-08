package controller;

import java.util.Scanner;
import domain.Car;
import view.PrintMessage;

public class Main {
	private static final Scanner scanner = new Scanner(System.in);
	private static final PrintMessage printMessage = new PrintMessage();
	private static Car car[];

	public static void main(String args[]) {
		init();
	}

	private static void init() {
		String inputString;
		do {
			printMessage.inputName();
			inputString = scanner.next();
		} while (validateInput(inputString) != true);
		car = new Car[inputString.split(",").length];
		for (int i = 0; i < car.length; i++) {
			car[i] = new Car(inputString.split(",")[i]);
		}
	}

	private static boolean validateInput(String inputString) {
		String inputArray[] = inputString.split(",");
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i].length() > 5) {
				return false;
			}
		}
		return true;
	}
}
