package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Game {
	public static void play() {
		System.out.println(Const.CAR_INPUT_MESSAGE);

		List<Car> cars = readCars();
		System.out.println(cars);
	}

	private static List<Car> readCars() {
		List<Car> result;

		String userInput = Console.readLine();
		List<String> names = Arrays.asList(userInput.split(","));

		try {
			result = Car.generateCars(names);
		} catch (IllegalArgumentException e) {
			System.out.println(Const.ERROR_INPUT_CAR_NAME_MESSAGE);
			return readCars();
		}

		return result;
	}
}
