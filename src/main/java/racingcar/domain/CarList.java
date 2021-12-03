package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class CarList {

	private static final List<Car> cars = new ArrayList<Car>();

	public static List<Car> input() {
		List<String> carNames = getValidCarNames();
		makeCarList(carNames);
		return cars;
	}

	private static List<String> getValidCarNames() {
		String input;
		List<String> carNames;

		do {
			input = Console.readLine();
			carNames = Arrays.asList(input.split(","));
		} while (isInvalid(carNames));

		return carNames;
	}

	private static void makeCarList(List<String> carNames) {
		for (String name : carNames) {
			cars.add(new Car(name));
		}
	}

	private static boolean isInvalid(List<String> carNames) {

		return false;
	}

}
