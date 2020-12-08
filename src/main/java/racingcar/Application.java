package racingcar;

import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		// TODO 구현 진행

		String input = scanner.nextLine();
		String[] inputCars = input.split(",");
		inputCars = checkInput(inputCars);

		for (int i = 0; i < inputCars.length; i++) {
			System.out.println(inputCars[i]);
		}

	}

	public static String[] checkInput(String[] inputCars) {
		int carCount = 0;
		String[] beforeInputCars = new String[inputCars.length];

		for (int number = 0; number < inputCars.length; number++) {
			if (checkLength(inputCars[number])) {
				beforeInputCars[carCount] = inputCars[number];
				carCount++;
			}
		}

		String[] affterInputCars = new String[carCount];
		for (int beforeNumber = 0; beforeNumber < carCount; beforeNumber++) {
			affterInputCars[beforeNumber] = beforeInputCars[beforeNumber];
		}

		return affterInputCars;
	}

	public static Boolean checkLength(String inputCar) {
		if (inputCar.length() <= 5) {
			return true;
		}
		return false;
	}
}
