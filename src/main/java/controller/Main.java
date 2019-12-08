package controller;

import java.util.Scanner;
import domain.Car;
import view.PrintMessage;

public class Main {
	private static final Scanner scanner = new Scanner(System.in);
	private static final Game game = new Game();
	private static Car car[];
	private static int round;

	public static void main(String args[]) {
		init();
		game.Start(car, round);
	}

	private static void init() {
		String inputString;
		do {
			PrintMessage.inputName();
			inputString = scanner.next();
		} while (validateInput(inputString) != true);
		car = new Car[inputString.split(",").length];
		for (int i = 0; i < car.length; i++) {
			car[i] = new Car(inputString.split(",")[i]);
		}
		PrintMessage.inputRound();
		round = scanner.nextInt();
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
