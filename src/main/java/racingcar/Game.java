package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Game {
	public static void play() {
		System.out.println(Const.CAR_INPUT_MESSAGE);
		readCars();
	}

	private static List<Car> readCars() {
		List<Car> result = new ArrayList<>();

		String userInput = Console.readLine();
		List<String> names = Arrays.asList(userInput.split(","));
		System.out.println(names);

		return result;
	}
}
