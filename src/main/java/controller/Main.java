package controller;

import java.util.Scanner;
import domain.Car;
import view.PrintMessage;

public class Main {
	private static final int LENGTH_LIMIT = 5;
	private static final Scanner scanner = new Scanner(System.in);
	private static final Game game = new Game();
	private static String inputString;
	private static Car car[];
	private static int round;

	public static void main(String args[]) {
		init();
		game.Start(car, round);
	}

	private static void init() {
		setName();
		setCar();
		setRound();
	}

	private static void setName() {
		do {
			PrintMessage.inputName();
			inputString = scanner.next();
		} while (validateInput(inputString) != true);
	}

	private static boolean validateInput(String inputString) {
		String inputArray[] = inputString.split(",");
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i].length() > LENGTH_LIMIT) {
				return false;
			}
		}
		return true;
	}

	private static void setCar() {
		car = new Car[inputString.split(",").length];
		for (int i = 0; i < car.length; i++) {
			car[i] = new Car(inputString.split(",")[i]);
		}
	}

	private static void setRound() {
		PrintMessage.inputRound();
		round = scanner.nextInt();
	}
}
