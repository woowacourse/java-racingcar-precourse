package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {
	public static void play() {
		List<Car> cars = readCars();
		int round = readRound();

		Race race = new Race(cars, round);

		race.start();
		race.printWinners();
	}

	private static List<Car> readCars() {
		System.out.println(Const.CAR_INPUT_MESSAGE);
		List<Car> result;

		String userInput = Console.readLine();
		List<String> names = Arrays.asList(userInput.split(Const.NAME_SEPARATOR));

		try {
			result = Car.generateCars(names);
		} catch (IllegalArgumentException e) {
			System.out.println(Const.ERROR_INPUT_CAR_NAME_MESSAGE);
			return readCars();
		}

		return result;
	}

	private static int readRound() {
		System.out.println(Const.ROUND_INPUT_MESSAGE);
		String userInput = Console.readLine();
		int result;
		try {
			result = validateRound(userInput);
		} catch (IllegalArgumentException e) {
			System.out.println(Const.ERROR_INPUT_ROUND_MESSAGE);
			return readRound();
		}

		return result;
	}

	private static int validateRound(String userInput) throws IllegalArgumentException {
		return Integer.parseInt(userInput);
	}

}
